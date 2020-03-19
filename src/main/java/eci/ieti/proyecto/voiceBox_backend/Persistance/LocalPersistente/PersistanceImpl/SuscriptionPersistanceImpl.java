package eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistanceImpl;

import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.SuscriptionPersistance;

public class SuscriptionPersistanceImpl implements SuscriptionPersistance {

    @Override
    public Boolean suscribe(long userId, long channelId) {
        return true;
    }

    @Override
    public Boolean unsuscribe(long userId, long channelId) {
        return true;
    }

}