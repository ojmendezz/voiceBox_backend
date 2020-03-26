package ieti.voicebox.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import ieti.voicebox.model.Channel;

public interface ChannelRepository extends MongoRepository<Channel, String>{ 

}
