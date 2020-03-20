package ieti.voicebox.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import ieti.voicebox.model.User;


public interface UserRepository extends MongoRepository<User, String>{
    

}