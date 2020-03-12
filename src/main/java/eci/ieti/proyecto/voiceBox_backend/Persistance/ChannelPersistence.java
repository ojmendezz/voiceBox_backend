package eci.ieti.proyecto.voiceBox_backend.Persistance;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.model.Channel;


public interface ChannelPersistence {
	public Channel createChannel(Channel channel ) throws PersistenceException;
	
	public Channel updateChannel(Channel channel) throws PersistenceException;

	public void addAudioBook(String channelName, AudioBook audiobook) throws PersistenceException;

	public List<AudioBook> getAudioBooksByChannelName(String channelName, AudioBook audiobook) throws PersistenceException;

	public void updateAudioBook(String channelName, AudioBook audioBook) throws PersistenceException ;
    
	public void removeAudioBook(String nameChannel, String audioBookName) throws PersistenceException;
}