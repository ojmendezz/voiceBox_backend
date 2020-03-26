package ieti.voicebox.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AudioBook {
	@Id
	private String audioBookId; // id que toca encontrar

	private final String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date()); // fecha de creacion
	private String name; // * nombre del audiolibro 
	private ArrayList<Comment> commentaries;
	private ArrayList<String> likesUsersId;
	private HashMap<Long, String> audios; 
	private String channelName; // *
	private String originalAuthor; //*
	private long price; // *
	private String tags;//*
	private String idImg;//*



	public AudioBook(){
		
	}

	public AudioBook(String channelName, String name,long price,String idImg,String tags,String og) {
		System.out.println("<z<zx<zx<zx<xz");
		this.name = name;
		this.channelName = channelName;
		this.commentaries = new ArrayList<>();
		this.likesUsersId = new ArrayList<>();
		this.audios = new HashMap<>();
		this.price = price;
		this.idImg =idImg;
		this.tags=tags;
		this.originalAuthor=og;
	}
		


	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

	public ArrayList<String> getLikesUsersId() {
		return likesUsersId;
	}

	public void setLikesUsersId(ArrayList<String> likesUsersId) {
		this.likesUsersId = likesUsersId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getIdImg() {
		return idImg;
	}

	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}

	public String getOriginalAuthor() {
		return originalAuthor;
	}

	public void setOriginalAuthor(String originalAuthor) {
		this.originalAuthor = originalAuthor;
	}

}