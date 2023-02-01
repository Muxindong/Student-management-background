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

//    增
    @PostMapping("/adduser")
    public Map<String,Object> addUser(@RequestBody User user){
        userRepository.save(user);
        Map<String,Object> res=new HashMap<>();
        Integer success=1;
        res.put("success",success);
        return res;
//        return "SUCCESS";
    }

//    //增
//    @RequestMapping("/adduser")
//    public String addUser(@RequestBody Integer idnumber){
//        userRepository.insertAdd(idnumber);
//        return "SUCCESS";
//    }

//    //增
//    @PostMapping("/adduser")
//    public String addUser(@RequestBody Integer idnumber,@RequestParam String name,@RequestParam String teacher,@RequestParam String time,@RequestParam Integer capacity,@RequestParam Integer number,@RequestParam String nature,@RequestParam String attribute,@RequestParam String unit,@RequestParam Integer credit,@RequestParam String explain){
//        userRepository.insertAdd(idnumber,name,teacher,time,capacity,number,nature,attribute,unit,credit,explain);
//        return "SUCCESS";
//    }

    //通过id删除
    @DeleteMapping("/deleteuser")
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "SUCCESS";
    }

    //通过id查询
    @GetMapping("/getUser")
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    //模糊查询+分页
    @RequestMapping("/search")
    public Map<String,Object> findSearch1(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String name,@RequestParam String nature,@RequestParam String attribute,@RequestParam Integer flag){
        Integer pagenumberfinstid=(pageNum-1)*pageSize;
        List<User> data;
        Integer total;
        if(flag==0){//显示所有课程
            data = userRepository.findSearch1(name,nature,attribute,pageSize, pagenumberfinstid);
            total = userRepository.selectSearchTotal1(name,nature,attribute);
        }
        else if(flag==1){//显示已选满课程
            data = userRepository.findSearch2(name,nature,attribute,pageSize, pagenumberfinstid);
            total = userRepository.selectSearchTotal2(name,nature,attribute);
        }
        else{//显示未选满课程
            data = userRepository.findSearch3(name,nature,attribute,pageSize, pagenumberfinstid);
            total = userRepository.selectSearchTotal3(name,nature,attribute);
        }
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    //将表中所有数据输出
    @RequestMapping("/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
