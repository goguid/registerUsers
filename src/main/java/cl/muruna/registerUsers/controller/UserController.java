package cl.muruna.registerUsers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.muruna.registerUsers.model.User;
import cl.muruna.registerUsers.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User usuario){

        String name = usuario.getName(); 
        System.out.println(name);
        User user = service.addUser(usuario);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }   
   /*  
    @PostMapping("/add")
    public ResponseEntity<User> listUser(){

        phone1 = new Phone("123456","1","4");
        phone2 = new Phone("123456","1","4");

        phones = [phone1,phone2];
        usuario = new User("gogas","gogas@gmail.com","123456",phones);
        
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
    */  
}
