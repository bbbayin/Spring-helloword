package com.paicaifu.app.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/2/18.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String age;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
