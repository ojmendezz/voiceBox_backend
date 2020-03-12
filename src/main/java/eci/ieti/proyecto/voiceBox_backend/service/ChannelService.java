package eci.ieti.proyecto.voiceBox_backend.service;

import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.model.Channel;

public interface ChannelService {
	
	AudioBook createAudioBook(AudioBook audiobook);
	
	Channel createChannel(Channel channel );
	
	Channel updateChannel(Channel channel);
	
	

}
