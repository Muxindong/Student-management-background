package com.example.springbooot.service;

import com.example.springbooot.dto.LoginDto;
import com.example.springbooot.dto.RegisterDto;

public interface TeacherService {
    // 注册
    RegisterDto register(RegisterDto dto);
    // 登录
    LoginDto login(LoginDto dto);
}
