package eci.ieti.proyecto.voiceBox_backend.Persistance;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.User;

public interface UserPersistence {
    public List<User> getAllUsers();

    public User getById(long userId) throws PersistenceException;

    public User create(User user) throws PersistenceException;

    public User update(User user) throws PersistenceException;

    public void remove(String userId) throws PersistenceException;
}