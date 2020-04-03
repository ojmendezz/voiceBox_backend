package ieti.voicebox.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ieti.voicebox.aws.bucket.BucketName;
import ieti.voicebox.aws.filestore.FileStore;
import ieti.voicebox.model.Channel;
import ieti.voicebox.model.User;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.persistence.UserRepository;

/**
 * @author Amalia Alfonso
 */
@Service
public class UserService{
    
    private final UserRepository userRepository;    
    private final FileStore fileStore;
    
    @Autowired
    public UserService(UserRepository userRepository,
    				FileStore fileStore) {
    	this.userRepository = userRepository;
    	this.fileStore = fileStore;
    	
    }
    
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String userName) throws PersistenceException{
        User user = userRepository.findById(userName).orElseThrow(() -> new PersistenceException("No se encontró el usuario"));
    	return user;
    }

    public void create(User user) throws PersistenceException {        
        long id = userRepository.count()+1;
		user.setUserID(id);
        userRepository.save(user);
    }

    public void update(User user) throws PersistenceException {
        Optional<User> userS = userRepository.findById(user.getUsername());
        if(userS == null){
            throw new PersistenceException("The user "+ user.getUsername() +" doesn't exit");
        }else{
            userRepository.save(user);
        }
    }

    public void updateChannel(Channel channel) throws PersistenceException {
        User user = userRepository.findById(channel.getUserName()).orElseThrow(() -> new PersistenceException("No se encontró el usuario"));
        if(user == null){
            throw new PersistenceException("The user "+ channel.getUserName() +" doesn't exit");
        }else{
            user.setChannel(channel);
            userRepository.save(user);
        }
    }

    public void remove(String userName) throws PersistenceException {
        Optional<User> userS = userRepository.findById(userName);
        if(userS == null){
            throw new PersistenceException("The user "+ userName +" doesn't exit");
        }else{
            userRepository.deleteById(userName);
        }
    }

    public void assignChannel(Channel channel) throws PersistenceException {        
        User user = userRepository.findById(channel.getUserName()).orElseThrow(() -> new PersistenceException("No se encontró el usuario"));
        if(user.getChannel() == null){
            user.setChannel(channel);
            userRepository.save(user);
        }else{
            throw new PersistenceException("The user already has a channel.");
        }		
    }
    
    public void uploadUserProfileImage(String username, MultipartFile file) {
		//1. check if image is not empty
		isFileEmpty(file);
		
		//2. check if file is an a image
		isImage(file);
		
		//3. the user exist in our database
		User user = getUserOrThrow(username);
		
		//4. Grap some metada from file any
		Map<String, String> metadata = extractMetadata(file);
		
		//5. Store the image in s3 and update database with s3 image link
		String path = String.format("%s/%s",BucketName.PROFILE_IMAGE.getBucketName(), user.getUsername());
		String fileName = String.format("%s-%s",UUID.randomUUID(),file.getOriginalFilename());
		
		try {
			fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
			user.setUserImageLink(fileName);
			userRepository.save(user);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	
	public byte[] downloadUserProfileImage(String username) {
		User user = getUserOrThrow(username);
		String path;
		String key;
		if(user.getUserImageLink() != null) {
			path = String.format("%s/%s", 
					BucketName.PROFILE_IMAGE.getBucketName(), 
					user.getUsername());
			key = user.getUserImageLink();					
		}else {
			
			path = String.format("%s/default-user", 
					BucketName.PROFILE_IMAGE.getBucketName());
			key = "default-user-image.jpeg";
			
		}
		byte[] image = fileStore.download(path, key);
		return image;
			
		/*
		return user.getUserImageLink()			
				.map( key -> fileStore.download(path, key) )
				.orElse(new byte[0]);
				*/
						
	}
	
	private Map<String, String> extractMetadata(MultipartFile file) {
		Map<String, String> metadata = new HashMap<String, String>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		return metadata;
	}

	private User getUserOrThrow(String username) {
		return userRepository
			.findAll()
			.stream()
			.filter(user -> user.getUsername().equals(username))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException(String.format("User with username %s not found", username)));
	}

	private void isImage(MultipartFile file) {
		if(! Arrays.asList(
				ContentType.IMAGE_JPEG.getMimeType(), 
				ContentType.IMAGE_PNG.getMimeType()).contains(file.getContentType()) ) {
			throw new IllegalStateException("File must be an image");
		}
	}

	private void isFileEmpty(MultipartFile file) {
		if(file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file [ "+ file.getSize() + "]" );
		}
	}
    
    
}