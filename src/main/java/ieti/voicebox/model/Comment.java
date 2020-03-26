package ieti.voicebox.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;

@Document
public class Comment{

    
    private long id;
    private String description;
    private String audioBook;
    private Long userName;
    private final String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    public Comment(){}

    public Comment(String description, String audioBook, long userName,long id) {

        this.id = (long) id;
        this.description = description;
        this.audioBook= audioBook;
        this.userName = (long) userName;

    }
    public Comment(String description, String audioBook, long userName) {

        this.description = description;
        this.audioBook=  audioBook;
        this.userName = (long) userName;

    }
    public void setId(long id){
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getAudioBook() {
        return audioBook;
    }
    public Long getuserName() {
        return userName;
    }
    public String getDate() {
        return date;
    }
    
}