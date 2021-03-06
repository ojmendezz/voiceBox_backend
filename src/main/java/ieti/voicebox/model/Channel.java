package ieti.voicebox.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Channel {
	@Id
	private String name;
	private long channelID;
	private String userName;
	private String idImg;
	private long followers;
	private HashMap<String, AudioBook> audioBooks;
	private String audioLink;
	
	public Channel(String name, String userName, String idImg) {
		this.name = name;
		this.userName = userName;
		this.followers = 0;
		this.audioBooks = new HashMap<>();
	}
	
	public String getAudioLink() {
		return audioLink;
	}

	public void setAudioLink(String audioLink) {
		this.audioLink = audioLink;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}