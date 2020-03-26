package ieti.voicebox.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ieti.voicebox.model.AudioBook;


public interface AudioBookRepository extends MongoRepository<AudioBook,String>{ 


    @Query(value = "{ 'array' : {$all : [?0] }}")
    public List<AudioBook> findAnyOfTheseValues(String[] arrayValues);


}