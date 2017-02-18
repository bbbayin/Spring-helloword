package com.paicaifu.app.domain;

/**
 * Created by Administrator on 2017/2/18.
 */
public class User {
    private long id;
    private String name;
    private String age;

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
