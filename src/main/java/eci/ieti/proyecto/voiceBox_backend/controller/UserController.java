package eci.ieti.proyecto.voiceBox_backend.controller;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Amalia Alfonso
 */

@RestController // 1
@RequestMapping(value = "/users") // 2
public class UserController {

    @Autowired
    private UserService userServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> manejadorGetRecursoUsers() {
        List<User> users = userServices.getAll();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public ResponseEntity<User> manejadorGetRecursoUserPorId(@PathVariable String userId) {
        User user = userServices.getById(userId);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> manejadorPostRecursoUser(@RequestBody User newUser) {
        User user = userServices.create(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> manejadorPUTRecursoUser(@RequestBody User updateUser) {
        User user = userServices.update(updateUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    public ResponseEntity<?> manejadorDeleteRecursoTarea(@PathVariable String userId) {
        userServices.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}