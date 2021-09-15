package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class UserApp {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String address;
    private Long zipcode;
    private String city;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleApp> roleApps = new ArrayList<>();




}



