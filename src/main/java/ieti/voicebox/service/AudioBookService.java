package ieti.voicebox.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import ieti.voicebox.model.*;
import ieti.voicebox.persistence.AudioBookRepository;

import ieti.voicebox.persistence.PersistenceException;

import org.apache.http.entity.ContentType;

@Configuration
public class AudioBookService{
	
	@Autowired
	private AudioBookRepository audioBookRepository;
	
	@Autowired 
	private ChannelService channelService;
	
	public List<AudioBook> getAllAudioBooks() {
        return audioBookRepository.findAll();
    }
	
	/*public List<Audio> getAudios(String audioBookId) {
		Optional<AudioBook> audios = audioBookRepository.findById(audioBookId);
		
		return null;
	}*/

	public AudioBook getById(String audioBookId) throws PersistenceException {
		AudioBook audioBook = audioBookRepository.findById(audioBookId).orElseThrow(() -> new PersistenceException("The audiobook was not found"));
	    return audioBook;
	}

	public void createAudioBook(AudioBook audioBookToSave) throws PersistenceException {		
		long id = audioBookRepository.count()+1;
		audioBookToSave.setAudioBookId(String.valueOf(id));
		channelService.addAudioBook(audioBookToSave);
		audioBookRepository.save(audioBookToSave);
	}

	public void updateAudioBook(AudioBook audioBook) throws PersistenceException {
		Optional<AudioBook> audiobook = audioBookRepository.findById(audioBook.getAudioBookId());
        if(audiobook == null){
            throw new PersistenceException("The audiobook "+ audioBook.getAudioBookId() +" doesn't exit");
        }else{
        	audioBookRepository.save(audioBook);
        }
	}

	/*falta al usuario eliminar el audiolibro*/
	public void removeAudioBook(String userChannel, String audioBookName) throws PersistenceException {
		channelService.removeAudioBook(userChannel, audioBookName);
	}

	public void removeAudioBook1(String audioBookId) throws PersistenceException {
		audioBookRepository.deleteById(audioBookId);
	}

	public void addAudio(long audioBookId, File audio) {
		System.out.println(audio);
	}
	
	public long countAudiobooks() throws PersistenceException {
        return audioBookRepository.count();
    } 

	public void createAudio(long audioBookId, Audio audio) {
		// TODO Auto-generated method stub
		
	}

	public Audio addAudio(MultipartFile audio, String audioBook) {
		System.out.println("entro 2");
		isFileEmpty(audio);
		
		//2. check if file is an a image
		isImage(audio);
		try {
			AudioBook audioB = getById(audioBook);
			//4. Grap some metada from file any
			Map<String, String> metadata = extractMetadata(audio);
			
			//5. Store the image in s3 and update database with s3 image link
			// String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
			// String fileName = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
			
			// try {
			// 	fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
			// 	user.setUserProfileImageLink(fileName);
			// } catch (IOException e) {
			// 	throw new IllegalStateException(e);
			// }
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("falta guardarlo");
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");

		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return null;
	}

	public List<AudioBook> searchByTags(String tag) {
		String[] tags = tag.split("&");
		return audioBookRepository.findAnyOfTheseValues(tags);

	}

	private void isImage(MultipartFile file) {
		if(! Arrays.asList(
				ContentType.MULTIPART_FORM_DATA.getMimeType(), 
				ContentType.MULTIPART_FORM_DATA .getMimeType()).contains(file.getContentType()) ) {
			throw new IllegalStateException("File must be an image");
		}
	}

	private void isFileEmpty(MultipartFile file) {
		if(file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file [ "+ file.getSize() + "]" );
		}
	}

	private Map<String, String> extractMetadata(MultipartFile file) {
		Map<String, String> metadata = new HashMap<String, String>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		return metadata;
	}

}
