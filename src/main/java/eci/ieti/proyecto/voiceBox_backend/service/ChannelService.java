package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.model.Channel;

public interface ChannelService {	
	Channel createChannel(Channel channel);
	
	Channel updateChannel(Channel channel);

	void addAudioBook(AudioBook audiobook);

	List<AudioBook> getAudioBooksByChannelName(String channelName, AudioBook audiobook);

	void updateAudioBook(String channelName, AudioBook audioBook);
    
	void removeAudioBook(String nameChannel, String audioBookName);	
}
