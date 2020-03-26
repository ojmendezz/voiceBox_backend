package ieti.voicebox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ieti.voicebox.model.Audio;
import ieti.voicebox.model.AudioBook;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.AudioBookService;

@Controller
@RequestMapping("audioBooks")
public class AudioBookController {

	@Autowired
	private AudioBookService audioBookService;

	@PostMapping()
	public ResponseEntity<?> createAudioBook(@RequestBody AudioBook audioBook) throws PersistenceException {
		try {
			audioBookService.createAudioBook(audioBook);
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("books/audiobook/{idAudioBook}")
	public ResponseEntity<?> createAudio(@RequestBody Audio audio) {
		return new ResponseEntity<>(audioBookService.createAudio(audio, 456), HttpStatus.OK);
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

	@RequestMapping(method = RequestMethod.DELETE, value = "{channel}/{audioBookName}")
	public ResponseEntity<?> deleteAudioBook(@PathVariable String channel, @PathVariable String audioBookName) throws PersistenceException {
		try {
			audioBookService.removeAudioBook(channel, audioBookName);
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{audioBookId}")
	public ResponseEntity<?> deleteAudioBook(@PathVariable String audioBookId) throws PersistenceException {
		try {
			audioBookService.removeAudioBook1(audioBookId);
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


}
