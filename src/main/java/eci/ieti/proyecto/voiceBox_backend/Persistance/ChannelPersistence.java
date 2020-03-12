package eci.ieti.proyecto.voiceBox_backend.Persistance;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.model.Channel;


public interface ChannelPersistence {
	private Channel createChannel(Channel channel ) throws PersistenceException;
	
	private Channel updateChannel(Channel channel) throws PersistenceException;

	private void addAudioBook(String channelName, AudioBook audiobook) throws PersistenceException;

	private List<AudioBook> getAudioBooksByChannelName(String channelName, AudioBook audiobook) throws PersistenceException;

	private void updateAudioBook(String channelName, AudioBook audioBook) throws PersistenceException ;
    
	private void removeAudioBook(String nameChannel, String audioBookName) throws PersistenceException;
}