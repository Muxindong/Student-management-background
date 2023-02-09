package com.example.springbooot.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="teacher")
public class Teacher {//该类为存储用户账号等信息的实体类
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String nickname;
    private String account;
}
