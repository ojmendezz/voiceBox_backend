package eci.ieti.proyecto.voiceBox_backend.model;

import java.util.HashMap;

public class Channel {
	
	private long channelID;
	private String name;
	private long followers;
	private HashMap<String, AudioBook> audioBooks;
	

	public Channel(String name) {
		super();
		this.name = name;
		this.followers = 0;
		this.audioBooks = new HashMap<>();
	}
	
	public long getChannelID() {
		return channelID;
	}
	public void setChannelID(long channelID) {
		this.channelID = channelID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFollowers() {
		return followers;
	}
	public void addFollower() {
		this.followers += 1;
	}

	public HashMap<String, AudioBook> getAudioBooks() {
		return audioBooks;
	}

	public void addAudioBooks(AudioBook audioBook) {
		this.audioBooks.put(audioBook.getName(), audioBook);
	}
	
	

}
