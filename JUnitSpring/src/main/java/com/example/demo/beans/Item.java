package com.example.demo.beans;
//build.gradle
//      implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
//      runtimeOnly 'com.h2database:h2'
//application.properties
//      #H2 configuration
//        spring.datasource.url=jdbc:h2:mem:testdb
//        spring.data.jpa.repositories.bootstrap-mode=default
//      #JPA -
//        spring.jpa.show-sql=true      -> see queries
//        spring.h2.console.enabled=true -> see H2 console
//creating entity
//  1)@Entity -> to bean
//      1)@Id needed
//  2)data.sql
//  3)localhost:8080/h2-console

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {
    @Id
    private int id;
    private String name;
    private double price;
    private int quantity;

    @Transient
    private double value;

    public Item() {
    }

    public Item(String name, int id, double price, int quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Item[%s %d %f %d]",name,id,price,quantity);
    }
}
