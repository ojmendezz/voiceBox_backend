package eci.ieti.proyecto.voiceBox_backend.model;

import java.util.ArrayList;
import java.util.HashMap;

public class AudioBook {	
	private long audioBookId;
	private String date;
	private User user;
	private String name;
	private ArrayList<Comment> commentaries;
	private ArrayList<String> likes;
	private HashMap<Long, String> audios;
	private long channelID;

	public AudioBook(String date, User user, String name, long channelID) {
		super();
		this.date = date;
		this.user = user;
		this.name = name;
		this.channelID = channelID;
		this.commentaries = new ArrayList<>();
		this.likes = new ArrayList<>();
		this.audios = new HashMap<>();
	}
	
	public long getChannelID() {
		return channelID;
	}
	public void setChannelID(long channelID) {
		this.channelID = channelID;
	}
	public long getAudioBookId() {
		return audioBookId;
	}
	public void setAudioBookId(long audioBookId) {
		this.audioBookId = audioBookId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Comment> getCommentaries() {
		return commentaries;
	}
	public void setCommentaries(ArrayList<Comment> commentaries) {
		this.commentaries = commentaries;
	}
	public ArrayList<String> getLikes() {
		return likes;
	}

	public void addLike(String userName) {
		likes.add(userName);
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

	public HashMap<Long, String> getAudios() {
		return audios;
	}

	public void setAudios(HashMap<Long, String> audios) {
		this.audios = audios;
	}
	
	public void addAudio(long audioId, String audio) {
		audios.put(audioId,audio);
	}

}
