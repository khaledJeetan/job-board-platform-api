package com.projects.jobplatform.controllers;

import com.projects.jobplatform.modles.User;
import com.projects.jobplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> retrieveAllUsers(){
        return userService.getUsers();
    }

    @GetMapping( "/{userId}")
    public ResponseEntity<User> retrieveUser(
            @PathVariable("userId") Long userId
    ){
        return ResponseEntity.ok().body(userService.getUser(userId));
    }

    @GetMapping("/email/{userName}")
    public ResponseEntity<User> retrieveUser(
            @PathVariable("userName") String userName
    ){
        return ResponseEntity.ok().body(userService.getUser(userName));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId")Long userId){
        return userService.deleteUser(userId) ?
                ResponseEntity.ok().body("User Deleted successfully.") :
                ResponseEntity.internalServerError().body("Error User can't be Deleted!!.");
    }
    @DeleteMapping("/email/{userName}")
    public ResponseEntity<String> deleteUser(@PathVariable("userName") String userName){
        return userService.deleteUser(userName) ?
                ResponseEntity.ok().body("User Deleted successfully.") :
                ResponseEntity.internalServerError().body("Error User can't be Deleted!!.");
    }

    @PutMapping( "/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable("userId") Long userId,
            @RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser(userId,user));
    }

    @PutMapping("/email/{userName}")
    public ResponseEntity<User> updateUser(
            @PathVariable("userName") String userName,
            @RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser( userName,user));
    }

}