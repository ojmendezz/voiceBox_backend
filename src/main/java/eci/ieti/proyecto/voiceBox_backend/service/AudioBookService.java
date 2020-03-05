package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.Audio;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;

public interface AudioBookService {
	
	List<Audio> getAudios(long audioBookId);
    
	AudioBook getById(long audioBookId);
    
	AudioBook createAudioBook(AudioBook audiobook);
    
    AudioBook updateAudioBook(AudioBook audioBook);
    
    void removeAudioBook(long audioBookId, long  userID, long bookId);
    
    Audio createAudio(Audio audio, long audioBook);
    
    void addAudio(long audioBookId, Audio audio);
    
    
    
}
