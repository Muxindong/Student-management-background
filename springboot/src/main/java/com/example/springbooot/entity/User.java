package com.example.springbooot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
}
