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
    private Integer id1;
    private String username1;
    private String password1;
}
