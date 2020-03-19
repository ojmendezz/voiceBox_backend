package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistenceMongoDB.UserRepository;
import eci.ieti.proyecto.voiceBox_backend.model.User;

/**
 * @author Amalia Alfonso
 */
@Configuration
public class UserService{
    @Autowired
    private UserRepository userRepository;

    
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String userName) throws PersistenceException{
        User user = userRepository.findById(userName).orElseThrow(() -> new PersistenceException("No se encontró el usuario"));
    	return user;
    }

    public void create(User user) throws PersistenceException {
        Optional<User> userS = userRepository.findById(user.getUsername());
        if(userS == null){
            userRepository.save(user);
        }else{
            throw new PersistenceException("The user "+ user.getUsername() +" already exit");
        }
        
    }

    public void update(User user) throws PersistenceException {
        Optional<User> userS = userRepository.findById(user.getUsername());
        if(userS == null){
            throw new PersistenceException("The user "+ user.getUsername() +" doesn't exit");
        }else{
            userRepository.save(user);
        }
    }

    public void remove(String userName) throws PersistenceException {
        Optional<User> userS = userRepository.findById(userName);
        if(userS == null){
            throw new PersistenceException("The user "+ userName +" doesn't exit");
        }else{
            userRepository.deleteById(userName);
        }
    }
}