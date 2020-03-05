package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.model.User;
import eci.ieti.proyecto.voiceBox_backend.service.LikeService;
import eci.ieti.proyecto.voiceBox_backend.service.UserService;

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