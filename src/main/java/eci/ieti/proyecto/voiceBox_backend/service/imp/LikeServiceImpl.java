package eci.ieti.proyecto.voiceBox_backend.service.imp;
import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.service.LikeService;

/**
 * @author Amalia Alfonso
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Override
    public long getByAudioId() {
        return 0;
    }


    @Override
    public void deleteLikeOfAudio(long audioLike, long userId) {

    }

	@Override
	public void addLikeToAudio(long audioBookId, long userId) {
		// TODO Auto-generated method stub
		
	}
    
}