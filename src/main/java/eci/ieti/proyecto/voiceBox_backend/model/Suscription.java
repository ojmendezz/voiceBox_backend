package eci.ieti.proyecto.voiceBox_backend.model;

public class Suscription{

    private long channelId;
    private String date;
    public Suscription(long channelId, String date){
        this.channelId = channelId;
        this.date = date;
    }

}