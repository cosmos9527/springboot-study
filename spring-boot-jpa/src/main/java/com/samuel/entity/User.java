package com.samuel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {

    private static final long serialVerisionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private int gender;
    private String telephone;
    private String email;
    @Column(name = "head_url")
    private String headUrl;

}
