package com.paicaifu.app.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bayin on 2017/2/24.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String rate;

    public Product() {}

    public Product(String name, String description, String rate) {
        this.name = name;
        this.description = description;
        this.rate = rate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}

