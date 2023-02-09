package com.example.springbooot.service;

import com.example.springbooot.dto.LoginDto;
import com.example.springbooot.dto.RegisterDto;

public interface TeacherService {
    // 教师注册
    RegisterDto register(RegisterDto dto);
    // 教师登录
    LoginDto login(LoginDto dto);
}
