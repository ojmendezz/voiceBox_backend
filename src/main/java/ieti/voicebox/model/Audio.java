package ieti.voicebox.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Audio {
	@Id
	private long audioId;
	private String name;
	private String audio;
	private String duration;
	private String description;
	private long audiobook;
	private long numReproductions;
	
	public Audio(String name, String audio, String duration, String description, long audiobook) {
		this.name = name;
		this.audio = audio;
		this.duration = duration;
		this.description = description;
		this.audiobook = audiobook;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getAudiobook() {
		return audiobook;
	}
	public void setAudiobook(long audiobook) {
		this.audiobook = audiobook;
	}
	public long getAudioId() {
		return audioId;
	}
	public void setAudioId(long audioId) {
		this.audioId = audioId;
	}
	public long getNumReproductions() {
		return numReproductions;
	}
	public void setNumReproductions(long numReproductions) {
		this.numReproductions = numReproductions;
	}
}
