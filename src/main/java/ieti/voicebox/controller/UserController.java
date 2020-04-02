package ieti.voicebox.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ieti.voicebox.model.User;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/users") // 2
public class UserController {

    
    private final UserService userServices;
    
    @Autowired
    public UserController(UserService userServices) {
    	this.userServices = userServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> manejadorGetRecursoUsers() {
        List<User> users = userServices.getAll();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    public ResponseEntity<User> manejadorGetRecursoUserPorId(@PathVariable String userName)
            throws PersistenceException {
        User user;
        try {
            user = userServices.getByUsername(userName);           
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userName}/{password}")
    public ResponseEntity<Boolean> manejadotVerificaUsuario(@PathVariable String userName,@PathVariable String password )
            throws PersistenceException {
        User user;
        System.out.println(userName);
        System.out.println(password);
        boolean correcto=false;
        try {
            user = userServices.getByUsername(userName);  
            if (user.getPassword().equals(password)) {
            	correcto = true;
            }
        } catch (PersistenceException e) {
        	System.out.println("The user "+userName+" does not exist");
        	throw new PersistenceException(e.getMessage()); 
        }
        return new ResponseEntity<>(correcto, HttpStatus.ACCEPTED);
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> manejadorPostRecursoUser(@RequestBody User newUser) throws PersistenceException {
        userServices.create(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> manejadorPUTRecursoUser(@RequestBody User updateUser) throws PersistenceException {
        try {
            userServices.update(updateUser);
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userName}")
    public ResponseEntity<?> manejadorDeleteRecursoTarea(@PathVariable String userName) throws PersistenceException {
        userServices.remove(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    } 

    @PostMapping("/suscribe/{userId}/{channelId")
    public ResponseEntity<Boolean> suscribeToChannel(@PathVariable("userId") String userId, @PathVariable("channelId") String channelId){
        return null;
    }
    
    @PostMapping(
			path = "{username}/image/upload",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			
	)
	public void uploadUserProfileImage(@PathVariable("username") String username,
										@RequestParam("file") MultipartFile file ) {		
		System.out.println(file.getContentType());
		userServices.uploadUserProfileImage(username, file);
		
	}
	
	@GetMapping(
			path = "{username}/image/download"
	)
	public byte[] downloadUserProfileImage(@PathVariable("username") String username) {
		return userServices.downloadUserProfileImage(username);
	}
    
    
    
    
}