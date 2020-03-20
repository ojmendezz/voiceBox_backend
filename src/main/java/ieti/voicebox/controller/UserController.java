package ieti.voicebox.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ieti.voicebox.model.User;
import ieti.voicebox.persistence.PersistenceException;
import ieti.voicebox.service.UserService;

@Controller
@RequestMapping(value = "/users") // 2
public class UserController {

    @Autowired
    private UserService userServices;

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
    public ResponseEntity<?> manejadorDeleteRecursoTarea(@PathVariable String userId) throws PersistenceException {
        userServices.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}