package ieti.voicebox.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ieti.voicebox.model.User;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.UserService;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(value = "/users") // 2
public class UserController {

    @Autowired
    private UserService userServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> manejadorGetRecursoUsers() {
        List<User> users = userServices.getAll();
        System.out.println("Encontrando users_");
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
}