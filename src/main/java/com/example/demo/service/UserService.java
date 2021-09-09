package com.example.demo.service;

import com.example.demo.domain.RoleApp;
import com.example.demo.domain.UserApp;

import java.util.List;

public interface UserService {
    UserApp saveUser(UserApp userApp);
    RoleApp saveRole(RoleApp roleApp);
    void addRoleToUser(String username, String roleName);
    UserApp getUser(String username);
    List<UserApp>getUsers();
}
