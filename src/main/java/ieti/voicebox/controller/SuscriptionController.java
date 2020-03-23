package ieti.voicebox.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ieti.voicebox.model.Suscription;
import ieti.voicebox.service.SuscriptionService;

@Controller
@RequestMapping("suscription")
public class SuscriptionController {

    @Autowired
    SuscriptionService suscriptionServices;

    @GetMapping("/user/{userName}")
    public ResponseEntity<List<Suscription>> getSuscriptionOfUser(@PathVariable String userName) {
        List<Suscription> comments = suscriptionServices.getSuscriptionFromUser(userName);
        return new ResponseEntity<>(comments, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Boolean> suscribe(@RequestBody Suscription suscription){
        Boolean ans = suscriptionServices.suscribe(suscription);
        return new ResponseEntity<>( ans , HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> unSuscribe(@RequestBody Suscription suscription){
        Boolean ans = suscriptionServices.unSuscribe(suscription);
        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }

    @GetMapping("/channel/{channelId}")
    public ResponseEntity<List<Suscription>> getSuscribersFromChannel(@PathVariable("channelId") long channelId){
        List<Suscription> suscribers = suscriptionServices.getSuscriptionsToChannel(channelId);
        return new ResponseEntity<>(suscribers,HttpStatus.ACCEPTED);
    }

}