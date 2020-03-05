package eci.ieti.proyecto.voiceBox_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eci.ieti.proyecto.voiceBox_backend.model.*;
import eci.ieti.proyecto.voiceBox_backend.service.AudioBookService;

@RestController
@RequestMapping("books/audioBooks")
public class AudioBookController {
	
	 @Autowired
	 private AudioBookService audioBookService;
	 
	 @PostMapping("/audiobooks")
	 public ResponseEntity<?> createAudioBook(@RequestBody AudioBook audioBook){
		 return new ResponseEntity<>(audioBookService.createAudioBook(audioBook), HttpStatus.OK);
	 }
	 
	 @PostMapping("books/audiobook/{idAudioBook}")
	 public ResponseEntity<?> createAudio(@RequestBody Audio audio){
		 return new ResponseEntity<>(audioBookService.createAudio(audio,456), HttpStatus.OK);
	 }
	 

}
