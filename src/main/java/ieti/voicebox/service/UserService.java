package ieti.voicebox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ieti.voicebox.model.Channel;
import ieti.voicebox.model.User;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.persistence.UserRepository;

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
        long id = userRepository.count()+1;
		user.setUserID(id);
        userRepository.save(user);
    }

    public void update(User user) throws PersistenceException {
        Optional<User> userS = userRepository.findById(user.getUsername());
        if(userS == null){
            throw new PersistenceException("The user "+ user.getUsername() +" doesn't exit");
        }else{
            userRepository.save(user);
        }
    }

    public void updateChannel(Channel channel) throws PersistenceException {
        User user = userRepository.findById(channel.getUserName()).orElseThrow(() -> new PersistenceException("No se encontró el usuario"));
        if(user == null){
            throw new PersistenceException("The user "+ channel.getUserName() +" doesn't exit");
        }else{
            user.setChannel(channel);
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

    public void assignChannel(Channel channel) throws PersistenceException {        
        User user = userRepository.findById(channel.getUserName()).orElseThrow(() -> new PersistenceException("No se encontró el usuario"));
        if(user.getChannel() == null){
            user.setChannel(channel);
            userRepository.save(user);
        }else{
            throw new PersistenceException("The user already has a channel.");
        }		
    }
}