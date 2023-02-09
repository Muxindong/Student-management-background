package com.example.springbooot.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String account;
    private String password;
    private String nickname;
    // 默认用户不存在
    private Boolean Exist = false;

    // 默认为合法
    private Boolean Illegal = true;
}
