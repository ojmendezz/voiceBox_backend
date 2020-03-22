package ieti.voicebox.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;

@Document
public class Commentary{

    
    private Long id;
    private String description;
    private Long audioBook;
    private Long user;
    private final String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    public Commentary(String description, long audioBook, long user,long id) {

        this.id = (long) id;
        this.description = description;
        this.audioBook= (long) audioBook;
        this.user = (long) user;

    }
    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public Long getAudioBook() {
        return audioBook;
    }
    public Long getUser() {
        return user;
    }
    public String getDate() {
        return date;
    }
    
}