package eci.ieti.proyecto.voiceBox_backend.service;

public interface SuscriptionService{
    public Boolean suscribe(long userId, long channelId, String date);
    public Boolean unSuscribe(long userId, long channelId);    
}