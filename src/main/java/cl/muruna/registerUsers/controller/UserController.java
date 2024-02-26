package cl.muruna.registerUsers.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.muruna.registerUsers.model.User;
import cl.muruna.registerUsers.service.UserService;
import cl.muruna.registerUsers.util.MessageResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User usuario){
        User user = service.addUser(usuario);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }   
     
    @GetMapping("/id/{uuid}")
    public ResponseEntity<User> listUser(@PathVariable UUID uuid){
        Optional<User> user = service.findUserByUUI(uuid);

        return user.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        
    }

    @GetMapping("/alluser")
    public ResponseEntity<List<User>> listAllUser(){
        List<User> allUser = service.findAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable UUID uuid) {
        service.deleteUser(uuid);
        MessageResponse mensaje = new MessageResponse("User deleted ok");
        return new ResponseEntity<>(mensaje,HttpStatus.OK);
    }

     @PutMapping("/update/{uuid}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable UUID uuid) {
        User updatedUser = service.updateUser(user, uuid);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
      
}
