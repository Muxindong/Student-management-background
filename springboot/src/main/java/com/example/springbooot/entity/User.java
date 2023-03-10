package com.example.springbooot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {//该类为存储课程信息的实体类
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idnumber;
    private String name;
    private String teacher;
    private String time;
    private Integer capacity;
    private Integer number;
    private String nature;
    private String attribute;
    private String unit;
    private Integer credit;
    private String explain;
    private Integer types;
    private String publicelective;
}
