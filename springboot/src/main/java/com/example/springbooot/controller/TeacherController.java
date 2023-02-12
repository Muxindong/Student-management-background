package com.example.springbooot.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.springbooot.dto.LoginDto;
import com.example.springbooot.dto.RegisterDto;
import com.example.springbooot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("register")
    public RegisterDto teacherRegister(@RequestBody RegisterDto dto) {

        RegisterDto register = teacherService.register ( dto );
        return register;
    }

    @PostMapping("login")
    public LoginDto teacherLogin(@RequestBody LoginDto dto) {
        return teacherService.login ( dto );
    }
}
