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
	private HashMap<Long, String> audios; // *
	private long channelId; // *
	private long price; // *



	public AudioBook(){
		
	}

	public AudioBook(long channelId, String name,long price) {
		System.out.println("<z<zx<zx<zx<xz");
		this.name = name;
		this.channelId = channelId;
		this.commentaries = new ArrayList<>();
		this.likesUsersId = new ArrayList<>();
		this.audios = new HashMap<>();
		this.price=price;
	}
	
	public long getChannelId() {
		return channelId;
	}
	public void setChannelID(long channelID) {
		this.channelId = channelID;
	}
	public String getAudioBookId() {
		return audioBookId;
	}
	public void setAudioBookId(String audioBookId) {
		this.audioBookId = audioBookId;
	}
	public String getDate() {
		return date;
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
		return likesUsersId;
	}
	public void setLikes(ArrayList<String> likes) {
		this.likesUsersId = likes;
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

	public long getPrice(){ return this.price;}
	public void setPrice(long p){ this.price=p;}

}