package ieti.voicebox.aws.filestore;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class FileStore {

	private final AmazonS3 s3;
	
	Logger logger = LoggerFactory.getLogger(FileStore.class);

	@Autowired
	public FileStore(AmazonS3 s3) {
		this.s3 = s3;
	}

	public void save(String path,
					 String fileName,
					 Optional<Map<String, String>> optinalMetadata,
					 InputStream inputStream) {
		ObjectMetadata metadata = new ObjectMetadata();
		optinalMetadata.ifPresent(map -> {
			if (!map.isEmpty()) {
				map.forEach(metadata::addUserMetadata);
			}
		});
		try {
			logger.info("Uploading file {} to {}", fileName, path);
			s3.putObject(path, fileName, inputStream, metadata);
		} catch (AmazonServiceException e) {
			throw new IllegalStateException("failed to store file to s3 ", e);
		}

	}
	
	public byte[] download(String path, String key) {
		try {
			S3Object object = s3.getObject(path, key);
			S3ObjectInputStream inputStream = object.getObjectContent();
			return IOUtils.toByteArray(inputStream);
		} catch (AmazonServiceException | IOException e) {
			throw new IllegalStateException("Failed to dowload filo from s3", e);
		}

	}
	
	public String getPresignedUrl(String bucketName, String key) {
		//Expiration time set to one hour
		Date expirationDate = Date.from(LocalDateTime.now()
				.plus(Duration.ofHours(1))
				.atZone(ZoneId.systemDefault())
				.toInstant());
		
		GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, key)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expirationDate);
		
        return s3.generatePresignedUrl(generatePresignedUrlRequest).toString();   
	}

}
