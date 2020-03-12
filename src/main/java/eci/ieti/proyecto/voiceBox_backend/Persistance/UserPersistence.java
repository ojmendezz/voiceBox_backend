package eci.ieti.proyecto.voiceBox_backend.Persistance;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.User;

public interface UserPersistence {
    private List<User> getAllUsers();

    private User getById(long userId) throws PersistenceException;

    private User create(User user) throws PersistenceException;

    private User update(User user) throws PersistenceException;

    private void remove(String userId) throws PersistenceException;
}