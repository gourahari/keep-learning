package com.example.docker.demo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBean {
    @Id
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UserBean createDummyUser() {
        UserBean user = new UserBean();
        user.setId(-1L);
        user.setName("Noname");
        return user;
    }
}
