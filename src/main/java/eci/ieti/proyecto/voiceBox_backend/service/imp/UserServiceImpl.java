package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.model.User;
import eci.ieti.proyecto.voiceBox_backend.service.UserService;

/**
 * @author Amalia Alfonso
 */
@Service
public class UserServiceImpl implements UserService {
    private String persistence;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public  User getById(long userId){
    	 return null;
    }

    @Override
    public User create(User user) {
        
        return null;
    }

    @Override
    public User update(User user) {
       
        return null;
    }

    @Override
    public void remove(String userId) {
        

    }
}