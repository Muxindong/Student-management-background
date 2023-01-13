package com.example.springbooot.dao;

import com.example.springbooot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    //分页
    @Query(value = "Select * from users limit ? offset ?", nativeQuery = true)
    List<User> findPage(Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users", nativeQuery = true)
    Integer selectTotal();


    //模糊查询+分页
    @Query(value = "Select * from users where name like concat('%', ? , '%') limit ? offset ?", nativeQuery = true)
    List<User> findSearch(String name,Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users where name like concat('%', ? , '%')", nativeQuery = true)
    Integer selectSearchTotal(String name);
}
