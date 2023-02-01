package com.example.springbooot.dao;

import com.example.springbooot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

//    //分页
//    @Query(value = "Select * from users limit ? offset ?", nativeQuery = true)
//    List<User> findPage(Integer pagesize,Integer pagenumberfinstid);
//
//    @Query(value = "SELECT count(*) from users", nativeQuery = true)
//    Integer selectTotal();


    //模糊查询+分页
    //以下两个为显示所有课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearch1(String name,String nature,String attribute,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') ", nativeQuery = true)
    Integer selectSearchTotal1(String name,String nature,String attribute);

    //以下两个为显示已满的课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity=number ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearch2(String name,String nature,String attribute,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity=number ", nativeQuery = true)
    Integer selectSearchTotal2(String name,String nature,String attribute);

    //以下两个为显示未满的课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity!=number ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearch3(String name,String nature,String attribute,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity!=number ", nativeQuery = true)
    Integer selectSearchTotal3(String name,String nature,String attribute);


    //增
//    @Query(value = "INSERT into users(idnumber,name,teacher,time,capacity,number,nature,attribute,unit,credit,explain) VALUES (?,?,?,?,?,?,?,?,?,?,?) ", nativeQuery = true)
//    Integer insertAdd(Integer idnumber,String name,String teacher,String time,Integer capacity,Integer number,String nature,String attribute,String unit,Integer credit,String explain);

//    @Query(value = "INSERT into users(idnumber) VALUES (?) ",nativeQuery = true)
//    Integer insertAdd(Integer idnumber);
}
