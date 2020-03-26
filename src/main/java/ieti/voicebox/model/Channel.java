package ieti.voicebox.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Channel {
	@Id
	private long channelID;
	private String name;	
	private String userName;	
	private long followers;
	private HashMap<String, AudioBook> audioBooks;
	

	public Channel(String name, String userName) {
		this.name = name;
		this.userName = userName;
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

	public String getUserName(){return userName;}
	
	
	

}