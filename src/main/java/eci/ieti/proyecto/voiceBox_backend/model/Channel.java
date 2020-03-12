package eci.ieti.proyecto.voiceBox_backend.model;

public class Channel {
	
	private long channelID;
	private String name;
	private long followers;
	

	public Channel(String name, long followers) {
		super();
		this.name = name;
		this.followers = followers;
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
	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	

}
