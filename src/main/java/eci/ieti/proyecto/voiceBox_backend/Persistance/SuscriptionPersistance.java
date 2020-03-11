package eci.ieti.proyecto.voiceBox_backend.Persistance;

public interface SuscriptionPersistance {

    public Boolean suscribe(long userId, long channelId);
    public Boolean unsuscribe(long userId, long channelId);
    
}