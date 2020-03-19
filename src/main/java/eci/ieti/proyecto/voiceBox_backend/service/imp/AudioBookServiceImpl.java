package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.model.Audio;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.service.AudioBookService;

@Service
public class AudioBookServiceImpl implements AudioBookService{

	@Override
	public List<Audio> getAudios(long audioBookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AudioBook getById(long audioBookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AudioBook createAudioBook(AudioBook audiobook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AudioBook updateAudioBook(AudioBook audioBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAudioBook(long audioBookId, long userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAudio(long audioBookId, Audio audio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Audio createAudio(Audio audio, long audioBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLike(String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLike(String userName) {
		// TODO Auto-generated method stub

	}

}
