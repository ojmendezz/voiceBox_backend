package eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.Persistance.UserPersistence;
import eci.ieti.proyecto.voiceBox_backend.model.User;

@Service
public class UserPersistenceImpl implements UserPersistence {
    private final HashMap<String, User> users = new HashMap<>(); 

    public UserPersistenceImpl() {
        User user1 = new User(1, "amalialfonsoc", "Amalia", "Mujer", "1999-09-09", "amalia@gmail.com", "amalia", "2020-02-05");
        User user2 = new User(2, "valesiabatto", "Valentina", "Mujer",  "1999-09-09", "valentina@gmail.com", "valentina", "2020-02-05");
        User user3 = new User(3, "willsonmelo", "Willson", "Hombre", "1999-09-09", "willson@gamil.com", "willson", "2020-02-05");
        User user4 = new User(4, "andresvillamil", "Andres", "Hombre", "1999-09-09", "andres@gmail.com", "andres", "2020-02-05");
        users.put(user1.getUsername(), user1);   
        users.put(user2.getUsername(), user2);
        users.put(user3.getUsername(), user3);
        users.put(user4.getUsername(), user4);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)users.values();
    }

    @Override
    public User getById(long userId) throws PersistenceException {
        List<User> listUsers = new ArrayList<>();
        User user = null;
        for (User u : users.values()) {
            if(u.getUserID() == userId){
                user=u;
            }
        }
        if(user == null){
            throw new PersistenceException("No existe un usuario con el id:" + userId);
        }
        return user;
    }

    @Override
    public User create(User newUser) {
        users.put(newUser.getUsername(), newUser);
        return newUser;
    }

    @Override
    public User update(User newUser) throws PersistenceException {
        users.replace(newUser.getUsername(), newUser);
        return newUser;
    }

    @Override
    public void remove(String userId) throws PersistenceException {
        users.remove(userId);
    }
}