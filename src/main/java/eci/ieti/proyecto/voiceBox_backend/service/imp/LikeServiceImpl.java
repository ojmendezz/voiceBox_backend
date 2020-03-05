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
    private Persistence persistence = new Persistence();

    @Override
    public long getByAudioId() {
        return 0;
    }
    
}