package ieti.voicebox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ieti.voicebox.model.AudioBook;
import ieti.voicebox.model.Channel;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.ChannelService;


@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(value = "/channels") 
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

    @RequestMapping(method = RequestMethod.GET, value = "/{channelName}/audiobooks")
	public ResponseEntity<?> getAudiobooksByChannelName(@PathVariable String channelName) throws PersistenceException {
		List<AudioBook> audioBooks = channelService.getAudioBooksByChannelName(channelName);
		return new ResponseEntity<>(audioBooks, HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{channelName}/audiobooks/{audiobookName}")
	public ResponseEntity<?> deleteAudiobooksByChannelName(@PathVariable String channelName, @PathVariable String audiobookName) throws PersistenceException {
		channelService.removeAudioBook(channelName, audiobookName);
		return new ResponseEntity<>(HttpStatus.OK, HttpStatus.ACCEPTED);
	}
	

}
