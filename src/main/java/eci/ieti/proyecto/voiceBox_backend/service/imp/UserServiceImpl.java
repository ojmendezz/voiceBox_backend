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
    private Persistence persistence = new Persistence();

    @Override
    public List<User> getAll() {
        return persistence.getAllUsers();
    }

    @Override
    public User getById(String userId) {
        return persistence.getUserById(userId);
    }

    @Override
    public User create(User user) {
        User newUer = persistence.addUser(user);
        return newUer;
    }

    @Override
    public User update(User user) {
        User newUer = persistence.updateUser(user);
        return newUer;
    }

    @Override
    public void remove(String userId) {
        persistence.deleteUser(userId);

    }

    @Override
    public User getById(String userId) {
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
}