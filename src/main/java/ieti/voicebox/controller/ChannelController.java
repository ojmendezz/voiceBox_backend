package ieti.voicebox.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ieti.voicebox.model.Channel;
import ieti.voicebox.model.User;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.ChannelService;
import ieti.voicebox.service.UserService;


@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(value = "/channel") 
public class ChannelController {
	
	 @Autowired
	 private ChannelService channelService;

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createChannel(@RequestBody Channel newChannel) throws PersistenceException {
        channelService.createChannel(newChannel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateChannel(@RequestBody Channel updateChannel) throws PersistenceException {
        try {
        	channelService.updateChannel(updateChannel);
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	

}
