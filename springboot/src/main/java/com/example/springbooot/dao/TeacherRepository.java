package com.example.springbooot.dao;

import com.example.springbooot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
    // 用户登录
    Optional<Teacher> findTeacherByAccount(String account);
}
