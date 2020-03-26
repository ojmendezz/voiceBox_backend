package ieti.voicebox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ieti.voicebox.model.*;
import ieti.voicebox.persistence.AudioBookRepository;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.persistence.UserRepository;

@Configuration
public class AudioBookService{
	
	@Autowired
    private AudioBookRepository audioBookRepository;
	
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

	public void createAudioBook(AudioBook audiobook) {
		AudioBook audioBookToSave = audiobook;
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
	public void removeAudioBook(String audioBookId, long userID) throws PersistenceException {
		Optional<AudioBook> audiobook = audioBookRepository.findById(audioBookId);
        if(audiobook == null){
            throw new PersistenceException("The audioBook "+ audioBookId +" doesn't exit");
        }else{
        	audioBookRepository.deleteById(audioBookId);
        }
		
	}

	public void addAudio(long audioBookId, Audio audio) {
		// TODO Auto-generated method stub
		
	}

	public Audio createAudio(Audio audio, long audioBook) {
		// TODO Auto-generated method stub
		return null;
	}

}
