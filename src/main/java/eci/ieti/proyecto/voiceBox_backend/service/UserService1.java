package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.User;

public interface UserService1 {
	
    List<User> getAll();
    
    User getByUsername(String userName) throws PersistenceException;
    
    void create(User user) throws PersistenceException;
    
    void update(User user) throws PersistenceException;
    
    void remove(String userId) throws PersistenceException;
}