package ieti.voicebox.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ieti.voicebox.model.Audio;
import ieti.voicebox.model.AudioBook;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.AudioBookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/audioBooks")
public class AudioBookController {
	
	@Autowired
	private AudioBookService audioBookService;
	
	@PostMapping
	public ResponseEntity<?> createAudioBook(@RequestBody AudioBook audioBook){
		try {
			
			audioBookService.createAudioBook(audioBook);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(audioBook.getChannelName(),HttpStatus.CREATED);
	}

	@PostMapping(path="/audiobooks/{channelId}",
				consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
				produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadAudios(@RequestBody MultipartFile audios, @PathVariable("channelId") String channelId){
		System.out.println("entro 1");
		audioBookService.addAudio(audios,channelId);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@PostMapping("books/audiobook/{idAudioBook}")
	public ResponseEntity<?> createAudio(@RequestBody MultipartFile audio){
		return new ResponseEntity<>(audioBookService.addAudio(audio,"456"), HttpStatus.OK);
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
	
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{channel}/{audioBookName}")
	public ResponseEntity<?> deleteAudioBook(@PathVariable String channel, @PathVariable String audioBookName) throws PersistenceException {
		try {
			audioBookService.removeAudioBook(channel, audioBookName);
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


}
