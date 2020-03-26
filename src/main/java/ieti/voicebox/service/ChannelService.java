package ieti.voicebox.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ieti.voicebox.model.*;
import ieti.voicebox.persistence.ChannelRepository;
import ieti.voicebox.persistence.PersistenceException;

@Configuration
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	private UserService userService;

	public void createChannel(Channel channel) throws PersistenceException {
		long id = channelRepository.count() + 1;
		channel.setChannelID(id);
		userService.assignChannel(channel);
		channelRepository.save(channel);
	}

	public void updateChannel(Channel channel) throws PersistenceException {
		Optional<Channel> channelS = channelRepository.findById(channel.getName());
		if (channelS == null) {
			throw new PersistenceException("The channel " + channel.getName() + " doesn't exit");
		} else {
			channelRepository.save(channel);
		}
	}

	public void addAudioBook(AudioBook audiobook) throws PersistenceException {
		Channel channel = channelRepository.findById(audiobook.getChannelName()).orElseThrow(() -> new PersistenceException("No se encontró el canal"));
		if(channel.getAudioBooks().containsKey(audiobook.getName())){
			throw new PersistenceException("There is already an audiobook with the name "+ audiobook.getName());			
		}else{
			channel.addAudioBooks(audiobook);
			userService.updateChannel(channel);
			channelRepository.save(channel);
		}		
	}

	public List<AudioBook> getAudioBooksByChannelName(String channelName) throws PersistenceException {
		Channel channel = channelRepository.findById(channelName).orElseThrow(() -> new PersistenceException("No se encontró el canal"));
		Collection<AudioBook> values = channel.getAudioBooks().values();
		ArrayList<AudioBook> listOfValues = new ArrayList<AudioBook>(values);
		return listOfValues;
	}

	public void updateAudioBook(String channelName, AudioBook audioBook) {

	}

	public void removeAudioBook(String nameChannel, String audioBookName) throws PersistenceException {
		Channel channel = channelRepository.findById(nameChannel).orElseThrow(() -> new PersistenceException("No se encontró el canal"));
		if (channel.getAudioBooks().containsKey(audioBookName)) {
			channel.getAudioBooks().remove(audioBookName);
			channelRepository.save(channel);
		} else {
			throw new PersistenceException("Audiobook does not exist.");
		}
	}
}