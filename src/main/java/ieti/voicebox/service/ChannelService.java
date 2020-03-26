package ieti.voicebox.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ieti.voicebox.model.*;
import ieti.voicebox.persistence.ChannelRepository;
import ieti.voicebox.persistence.PersistenceException;

@Configuration
public class ChannelService{
	
	@Autowired
	private ChannelRepository channelRepository;


	public void createChannel(Channel channel) {
		System.out.println(channel.toString());
		channelRepository.save(channel);
	}

	public void updateChannel(Channel channel) throws PersistenceException {
		Optional<Channel> channelS = channelRepository.findById(channel.getName());
        if(channelS == null){
            throw new PersistenceException("The channel "+ channel.getName() +" doesn't exit");
        }else{
        	channelRepository.save(channel);
        }
	}

	public void addAudioBook(AudioBook audiobook) {

	}

	public List<AudioBook> getAudioBooksByChannelName(String channelName, AudioBook audiobook) {
		return null;
	}

	public void updateAudioBook(String channelName, AudioBook audioBook) {

	}

	public void removeAudioBook(String nameChannel, String audioBookName) {

	}
}