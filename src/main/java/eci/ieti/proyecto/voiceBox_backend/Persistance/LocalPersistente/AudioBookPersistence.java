package eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.Audio;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;

public interface AudioBookPersistence {
    public List<Audio> getAudios(long audioBookId) throws PersistenceException;
    
	public AudioBook getById(long audioBookId) throws PersistenceException;
     
    public AudioBook updateAudioBook(AudioBook audioBook) throws PersistenceException;
    
    public void removeAudioBook(long audioBookId, long  userID) throws PersistenceException;
    
    public Audio createAudio(Audio audio, long audioBook) throws PersistenceException;
    
    public void addAudio(long audioBookId, Audio audio) throws PersistenceException;
}