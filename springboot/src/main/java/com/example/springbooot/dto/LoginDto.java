package com.example.springbooot.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String account;
    private String password;
    private String nickname;
    // 默认用户存在
    private Boolean Exist = true;

    // 默认为合法
    private Boolean Illegal = true;
}
