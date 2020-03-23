package ieti.voicebox.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ieti.voicebox.model.Suscription;


public interface SuscriptionRepository extends MongoRepository<Suscription, String>{ 

    @Query
    public void deleteByUserNameAndChannelId(String userName, long channelId);

    public List<Suscription> findAllByUserName(String userName);

    public List<Suscription> findAllByChannelId(long channelId);





}