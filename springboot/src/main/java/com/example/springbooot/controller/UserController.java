package com.example.springbooot.controller;

import com.example.springbooot.dao.UserRepository;
import com.example.springbooot.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user){

        userRepository.save(user);
        return "SUCCESS";
    }

    @DeleteMapping("/deleteuser")
    public String deleteUser(Integer id) {

        userRepository.deleteById(id);
        return "SUCCESS";
    }

    @GetMapping("/getUser")
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    @RequestMapping("/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
