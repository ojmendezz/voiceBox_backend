package eci.ieti.proyecto.voiceBox_backend.Persistance.PersistenceMongoDB;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.ieti.proyecto.voiceBox_backend.model.User;

public interface UserRepository extends MongoRepository<User, String>{
    List<User> getAllUsers();

    User getById(long userId);

    User create(User user);

    User update(User user);

    void remove(String userId);

}