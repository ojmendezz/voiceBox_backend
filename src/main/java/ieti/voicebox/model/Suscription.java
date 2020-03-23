package ieti.voicebox.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Suscription{
    private long channelId;
    private String userName;
    private String sDate;
	public Suscription(long channelId, String userName) {
		this.channelId = channelId;
        this.userName = userName;
        String pattern = "MM/dd/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();  
        this.sDate = df.format(today);
        
    }
	public long getChannelId() {
		return channelId;
	}
	public String getUserName() {
		return userName;
	}
	public String getsDate() {
		return sDate;
	}
	


}