package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.User;

public interface UserService {
    List<User> getAll();
    
    User getById(String userId);
    
    User create(User user);
    
    User update(User user);
    
    void remove(String userId);
}