package eci.ieti.proyecto.voiceBox_backend.model;

public class Audio {	
	private long id;
	private String name;
	private String audio;
	private String duration;
	private String description;
	private long audiobook;
	private long audioId;
	private long numReproductions;
	
	public Audio(long id, String name, String audio, String duration, String description, long audiobook) {
		this.id = id;
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
