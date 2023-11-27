package com.example.msusers.domain;

import lombok.*;

import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class User {

    private String id;

    private String name;

    private String lastName;

    private String email;

    private List<Bill> bills;

    public User(String id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}
