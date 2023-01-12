package com.example.springbooot.controller;

import com.example.springbooot.dao.UserRepository;
import com.example.springbooot.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @RequestMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Integer pagenumberfinstid=(pageNum-1)*pageSize;
        List<User> data = userRepository.findPage(pageSize, pagenumberfinstid);
        Integer total = userRepository.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    @RequestMapping("/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
