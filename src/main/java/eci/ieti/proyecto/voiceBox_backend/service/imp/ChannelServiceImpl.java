package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.HashMap;
import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.model.Channel;
import eci.ieti.proyecto.voiceBox_backend.service.ChannelService;

public class ChannelServiceImpl implements ChannelService {
	private final HashMap<String, AudioBook> audioBooks = new HashMap<>();

	@Override
	public Channel createChannel(Channel channel) {
		return null;
	}

	@Override
	public Channel updateChannel(Channel channel) {
		return null;
	}

	@Override
	public void addAudioBook(AudioBook audiobook) {

	}

	@Override
	public List<AudioBook> getAudioBooksByChannelName(String channelName, AudioBook audiobook) {
		return null;
	}

	@Override
	public void updateAudioBook(String channelName, AudioBook audioBook) {

	}

	@Override
	public void removeAudioBook(String nameChannel, String audioBookName) {

	}
}
