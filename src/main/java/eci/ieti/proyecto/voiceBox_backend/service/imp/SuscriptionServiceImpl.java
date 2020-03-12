package eci.ieti.proyecto.voiceBox_backend.service.imp;

import eci.ieti.proyecto.voiceBox_backend.service.SuscriptionService;

public class SuscriptionServiceImpl implements SuscriptionService{

    @Override
    public Boolean suscribe(long userId, long channelId) {
        return true;

    }

    @Override
    public Boolean unSuscribe(long userId, long channelId) {
        return true;

    }

}