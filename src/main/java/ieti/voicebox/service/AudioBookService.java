package ieti.voicebox.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import ieti.voicebox.aws.bucket.BucketName;
import ieti.voicebox.aws.filestore.FileStore;
import ieti.voicebox.model.Audio;
import ieti.voicebox.model.AudioBook;
import ieti.voicebox.persistence.AudioBookRepository;
import ieti.voicebox.persistence.PersistenceException;

@Configuration
public class AudioBookService{
	
	@Autowired
	private AudioBookRepository audioBookRepository;
	
	@Autowired 
	private ChannelService channelService;
	
	@Autowired
	FileStore fileStore;
	
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

	public void addAudio(long audioBookId, Audio audio) {
		// TODO Auto-generated method stub
		
	}

	public Audio createAudio(Audio audio, long audioBook) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AudioBook> searchByTags(String tag) {
		String[] tags = tag.split("&");
		return audioBookRepository.findAnyOfTheseValues(tags);

	}

	public void uploadAudio(String name, MultipartFile file) throws IOException {
		//1. check if audio is not empty
		isFileEmpty(file);
		//2. check if file is an audio
		isAudio(file);
		//3. Upload file to AWS
		fileStore.save(BucketName.AUDIO_FILE.getBucketName(), file.getOriginalFilename(), Optional.empty(), file.getInputStream());
		
	}
	
	public String getAudioUrl(String name) {
		return fileStore.getPresignedUrl(BucketName.AUDIO_FILE.getBucketName(), name);
	}

	private void isAudio(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	private void isFileEmpty(MultipartFile file) {
		if(file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file [ "+ file.getSize() + "]" );
		}
	}

}
