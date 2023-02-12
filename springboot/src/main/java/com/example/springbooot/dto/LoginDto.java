package com.example.springbooot.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String account;
    private String password;
    private String nickname;
    private Integer flag;//标记普通用户与管理员，管理员为0，普通用户为1
    private String token;
    // 默认用户存在
    private Boolean Exist = true;

    // 默认为合法
    private Boolean Illegal = true;
}
