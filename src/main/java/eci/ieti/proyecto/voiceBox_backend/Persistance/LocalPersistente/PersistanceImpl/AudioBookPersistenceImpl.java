package eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistanceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.AudioBookPersistence;
import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.Audio;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;

@Service
public class AudioBookPersistenceImpl implements AudioBookPersistence {
    private final HashMap<String, AudioBook> audioBooks = new HashMap<>();

    @Override
    public List<Audio> getAudios(long audioBookId) throws PersistenceException {
        return null;
    }

    @Override
    public AudioBook getById(long audioBookId) throws PersistenceException {
        return null;
    }

    @Override
    public AudioBook updateAudioBook(AudioBook audioBook) throws PersistenceException {
        return null;
    }

    @Override
    public void removeAudioBook(long audioBookId, long userID) throws PersistenceException {

    }

    @Override
    public Audio createAudio(Audio audio, long audioBook) throws PersistenceException {
        return null;
    }

    @Override
    public void addAudio(long audioBookId, Audio audio) throws PersistenceException {

    }
    
}