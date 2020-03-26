package ieti.voicebox.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AudioBook {
	@Id
	private String audioBookId;
	private String date;
	private String userChannel;
	private String name;
	private String idImg;
	private ArrayList<Comment> commentaries;
	private ArrayList<String> likesUsersId;
	private HashMap<Long, String> audios;
	private long channelID;
	private long price;

	public AudioBook(String date, String userChannel, String name, long price, String idImg) {
		this.date = date;
		this.userChannel = userChannel;
		this.name = name;
		this.idImg = idImg;
		this.commentaries = new ArrayList<>();
		this.likesUsersId = new ArrayList<>();
		this.audios = new HashMap<>();
		this.price = price;
	}

	public long getChannelID() {
		return channelID;
	}

	public void setChannelID(final long channelID) {
		this.channelID = channelID;
	}

	public String getAudioBookId() {
		return audioBookId;
	}

	public void setAudioBookId(final String audioBookId) {
		this.audioBookId = audioBookId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public ArrayList<Comment> getCommentaries() {
		return commentaries;
	}

	public void setCommentaries(final ArrayList<Comment> commentaries) {
		this.commentaries = commentaries;
	}

	public ArrayList<String> getLikes() {
		return likesUsersId;
	}

	public void setLikes(final ArrayList<String> likes) {
		this.likesUsersId = likes;
	}

	public HashMap<Long, String> getAudios() {
		return audios;
	}

	public void setAudios(final HashMap<Long, String> audios) {
		this.audios = audios;
	}

	public void addAudio(final long audioId, final String audio) {
		audios.put(audioId, audio);
	}

	public long getPrice() {
		return this.price;
	}

	public void setPrice(final long p) {
		this.price = p;
	}

	public String getUserChannel() {
		return userChannel;
	}

	public void setUserChannel(String userChannel) {
		this.userChannel = userChannel;
	}

}