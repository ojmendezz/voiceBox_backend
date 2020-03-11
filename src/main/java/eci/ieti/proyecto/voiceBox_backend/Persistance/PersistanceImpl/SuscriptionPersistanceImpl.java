package eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl;

import eci.ieti.proyecto.voiceBox_backend.Persistance.SuscriptionPersistance;

public class SuscriptionPersistanceImpl implements SuscriptionPersistance{

    @Override
    public Boolean suscribe(long userId, long channelId) {
        return true;
    }

    @Override
    public Boolean unsuscribe(long userId, long channelId) {
        return true;
    }

}