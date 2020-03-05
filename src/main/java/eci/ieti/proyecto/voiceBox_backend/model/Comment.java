package eci.ieti.proyecto.voiceBox_backend.model;

import java.util.Date;

import java.text.SimpleDateFormat;


public class Comment{

    
    private Long id;
    private String description;
    private Long audioBook;
    private Long user;
    private final String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    public Comment(String description, int audioBook, int user,int id) {

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