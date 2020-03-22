package ieti.voicebox.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ieti.voicebox.model.Suscription;
import ieti.voicebox.persistence.SuscriptionRepository;


public class SuscriptionService {

    @Autowired
    private SuscriptionRepository suscriptionRepository;
    public Boolean suscribe(Suscription suscription) {
        suscriptionRepository.save(suscription);
        return true;

    }
    public Boolean unSuscribe(Suscription suscription) {
        suscriptionRepository.deleteByUserNameAndChannelId(suscription.getUserName(),suscription.getChannelId());
        return true;
    }

    public List<Suscription> getSuscriptionFromUser(String userName){
        return suscriptionRepository.findAllByUserName(userName);
    }

    public List<Suscription> getSuscriptionsToChannel(long channelId){
        return suscriptionRepository.findAllByChannelId(channelId);
    }

}