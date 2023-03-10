package com.example.springbooot.controller;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.springbooot.dao.UserRepository;
import com.example.springbooot.entity.User;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String USER_KEY = "USER_SEARCH";

    //增
    @PostMapping("/adduser")
    public Map<String,Object> addUser(@RequestBody User user){
        userRepository.save(user);
        Map<String,Object> res=new HashMap<>();
        Integer success=1;
        res.put("success",success);
//        flushRedis(USER_KEY);
        return res;
    }

    //通过id删除
    @DeleteMapping("/deleteuser")
    public Map<String,Object> deleteUser(Integer id) {
        userRepository.deleteById(id);
        Map<String,Object> res=new HashMap<>();
        Integer success=1;
        res.put("success",success);
//        flushRedis(USER_KEY);
        return res;
    }

    //通过id查询
    @GetMapping("/getUser")
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

//    //模糊查询+分页(系统推荐课程页面)
//    @RequestMapping("/search")
//    public Map<String,Object> findSearch1(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String name,@RequestParam String nature,@RequestParam String attribute,@RequestParam Integer flag){
//        Map<String,Object> res=new HashMap<>();
//        String jsonStr = stringRedisTemplate.opsForValue().get(USER_KEY);
//        if(StrUtil.isBlank(jsonStr)){
//            Integer pagenumberfinstid=(pageNum-1)*pageSize;
//            List<User> data;
//            Integer total;
//            if(flag==0){//显示所有课程
//                data = userRepository.findSearch1(name,nature,attribute,pageSize, pagenumberfinstid);
//                total = userRepository.selectSearchTotal1(name,nature,attribute);
//            }
//            else if(flag==1){//显示已选满课程
//                data = userRepository.findSearch2(name,nature,attribute,pageSize, pagenumberfinstid);
//                total = userRepository.selectSearchTotal2(name,nature,attribute);
//            }
//            else{//显示未选满课程
//                data = userRepository.findSearch3(name,nature,attribute,pageSize, pagenumberfinstid);
//                total = userRepository.selectSearchTotal3(name,nature,attribute);
//            }
//            res.put("data",data);
//            res.put("total",total);
//            stringRedisTemplate.opsForValue().set(USER_KEY,JSONUtil.toJsonStr(res));
//        }
//        else{
//            res = JSONUtil.toBean(jsonStr, new TypeReference<Map<String,Object>>() {
//            },true);
//        }
//        return res;
//    }

    //模糊查询+分页(系统推荐课程页面)
    @RequestMapping("/search")
    public Map<String,Object> findSearch1(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String name,@RequestParam String nature,@RequestParam String attribute,@RequestParam Integer flag){
        Map<String,Object> res=new HashMap<>();
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
        res.put("data",data);
        res.put("total",total);
        return res;
    }


    //模糊查询+分页(校公选课页面)
    @RequestMapping("/searchp")
    public Map<String,Object> findSearchp1(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@RequestParam String name,@RequestParam String nature,@RequestParam String publicelective,@RequestParam Integer flag){
        Integer pagenumberfinstid=(pageNum-1)*pageSize;
        List<User> data;
        Integer total;
        if(flag==0){//显示所有课程
            data = userRepository.findSearchp1(name,nature,publicelective,pageSize, pagenumberfinstid);
            total = userRepository.selectSearchTotalp1(name,nature,publicelective);
        }
        else if(flag==1){//显示已选满课程
            data = userRepository.findSearchp2(name,nature,publicelective,pageSize, pagenumberfinstid);
            total = userRepository.selectSearchTotalp2(name,nature,publicelective);
        }
        else{//显示未选满课程
            data = userRepository.findSearchp3(name,nature,publicelective,pageSize, pagenumberfinstid);
            total = userRepository.selectSearchTotalp3(name,nature,publicelective);
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

    private void flushRedis(String key){
        stringRedisTemplate.delete(key);
    }
}
