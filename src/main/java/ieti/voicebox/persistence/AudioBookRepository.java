package ieti.voicebox.persistence;


import org.springframework.data.mongodb.core.ExecutableFindOperation.FindWithQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import ieti.voicebox.model.AudioBook;


public interface AudioBookRepository extends MongoRepository<AudioBook,String>{ 
   
}