package com.example.controllers;

import com.example.DTO.AuthRequestDTO;
import com.example.DTO.UserRequestFromFrontDTO;
import com.example.entites.UserApp;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<UserApp> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/post")
    public UUID createUser(@RequestBody UserRequestFromFrontDTO userRequestFromFrontDTO){
        return this.userService.create(userRequestFromFrontDTO);
    }

    @GetMapping("/{idUser}")
    public UserApp getUserById(@PathVariable("idUser") UUID idUser){
        return this.userService.getById(idUser);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        this.userService.delete(id);
    }

    @GetMapping("getByRole/{role}")
    public List<UserApp> getUserByRole(@PathVariable("role") String role){
        return this.userService.getUserByRole(role);
    }
    @GetMapping("/login")
    public UUID login(@RequestBody AuthRequestDTO authRequestDTO){
        return this.userService.login(authRequestDTO);
    }


}
