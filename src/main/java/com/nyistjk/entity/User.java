package com.nyistjk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lvbowen on 2017/4/21.
 * we will be the best
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;
    private Integer level;
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public User(String userName, String password, Integer level) {

        this.userName = userName;
        this.password = password;
        this.level = level;
    }
}
