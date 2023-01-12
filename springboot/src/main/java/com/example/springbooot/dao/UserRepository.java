package com.example.springbooot.dao;

import com.example.springbooot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "Select * from users limit ? offset ?", nativeQuery = true)
    List<User> findPage(Integer pagesize,Integer pagenumberfinstid);

    @Query(value = "SELECT count(*) from users", nativeQuery = true)
    Integer selectTotal();
}
