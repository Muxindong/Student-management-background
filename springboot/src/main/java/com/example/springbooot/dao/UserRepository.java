package com.example.springbooot.dao;

import com.example.springbooot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    //模糊查询+分页(系统推荐课程页面)
    //以下两个为显示所有课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND types='1' AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearch1(String name,String nature,String attribute,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND types='1' AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') ", nativeQuery = true)
    Integer selectSearchTotal1(String name,String nature,String attribute);

    //以下两个为显示已满的课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND types='1' AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity=number ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearch2(String name,String nature,String attribute,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND types='1' AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity=number ", nativeQuery = true)
    Integer selectSearchTotal2(String name,String nature,String attribute);

    //以下两个为显示未满的课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND types='1' AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity!=number ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearch3(String name,String nature,String attribute,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND types='1' AND nature like concat('%', ? , '%') AND attribute like concat('%', ? , '%') AND capacity!=number ", nativeQuery = true)
    Integer selectSearchTotal3(String name,String nature,String attribute);



    //模糊查询+分页(校公选课页面)
    //以下两个为显示所有课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND types='2' AND nature like concat('%', ? , '%') AND publicelective like concat('%', ? , '%') ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearchp1(String name,String nature,String publicelective,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND types='2' AND nature like concat('%', ? , '%') AND publicelective like concat('%', ? , '%') ", nativeQuery = true)
    Integer selectSearchTotalp1(String name,String nature,String publicelective);

    //以下两个为显示已满的课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND types='2' AND nature like concat('%', ? , '%') AND publicelective like concat('%', ? , '%') AND capacity=number ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearchp2(String name,String nature,String publicelective,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND types='2' AND nature like concat('%', ? , '%') AND publicelective like concat('%', ? , '%') AND capacity=number ", nativeQuery = true)
    Integer selectSearchTotalp2(String name,String nature,String publicelective);

    //以下两个为显示未满的课程
    @Query(value = "Select * from users where name like concat('%', ? , '%') AND types='2' AND nature like concat('%', ? , '%') AND publicelective like concat('%', ? , '%') AND capacity!=number ORDER BY id limit ? offset ?", nativeQuery = true)
    List<User> findSearchp3(String name,String nature,String publicelective,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%') AND types='2' AND nature like concat('%', ? , '%') AND publicelective like concat('%', ? , '%') AND capacity!=number ", nativeQuery = true)
    Integer selectSearchTotalp3(String name,String nature,String publicelective);
}
