package com.example.springbooot;

import com.example.springbooot.entity.User;
import com.example.springbooot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class SpringboootApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringboootApplication.class, args);
    }

    @GetMapping("/")
    public List<User> index(){
        return userMapper.findAll();
    }
}
