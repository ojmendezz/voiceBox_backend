package ieti.voicebox.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ieti.voicebox.model.Audio;
import ieti.voicebox.model.AudioBook;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.AudioBookService;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/audioBooks")
public class AudioBookController {
	
	@Autowired
	private AudioBookService audioBookService;
	
	@PostMapping("/audiobooks")
	public ResponseEntity<Long> createAudioBook(@RequestBody AudioBook audioBook){
		System.out.println("entro ");
		audioBookService.createAudioBook(audioBook);
		return new ResponseEntity<>(audioBook.getChannelId(),HttpStatus.CREATED);
	}

	@PostMapping("/audiobooks/{channelId}")
	public ResponseEntity<?> uploadAudios(@RequestBody File audios, @PathVariable long channelId){
		audioBookService.addAudio(channelId,audios);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PostMapping("books/audiobook/{idAudioBook}")
	public ResponseEntity<?> createAudio(@RequestBody Audio audio){
		return new ResponseEntity<>(audioBookService.createAudio(audio,456), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllAudiobooks() {
		List<AudioBook> audiobooks = audioBookService.getAllAudioBooks();
		return new ResponseEntity<>(audiobooks, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{audiobookId}")
	public ResponseEntity<AudioBook> getAudiobookById(@PathVariable String audiobookId) throws PersistenceException {
		AudioBook audioBook;
		try {
			audioBook = audioBookService.getById(audiobookId);           
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage());
		}
		return new ResponseEntity<>(audioBook, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateAudioBook(@RequestBody AudioBook aupdateAudiobook) throws PersistenceException {
		try {
			audioBookService.updateAudioBook(aupdateAudiobook);
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value="/busqueda?{tags}", method=RequestMethod.GET)
	public List<AudioBook> searchByTags(@PathVariable String tags) {
		return audioBookService.searchByTags(tags);
	}
	
	
	
}
