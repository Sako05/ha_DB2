package com.example.demo.service;


import com.example.demo.model.RoleApp;
import com.example.demo.model.UserApp;
import com.example.demo.repositories.RoleResourceRepository;
import com.example.demo.repositories.UserResourceRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {
    private final UserResourceRepo userResourceRepo;
    private final RoleResourceRepository roleResourceRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = userResourceRepo.findByUsername(username);
        if(userApp == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userApp.getRoleApps().forEach(roleApp -> authorities.add(new SimpleGrantedAuthority(roleApp.getName())));
        return new org.springframework.security.core.userdetails.User(userApp.getUsername(), userApp.getPassword(), authorities);
    }

    @Override
    public UserApp saveUser(UserApp userApp) {
        log.info("Saving new user {} to the database", userApp.getFirstname());
        userApp.setPassword(passwordEncoder.encode(userApp.getPassword()));
        return userResourceRepo.save(userApp);
    }

    @Override
    public RoleApp saveRole(RoleApp roleApp) {
        log.info("Saving new role {} to the database", roleApp.getName());
        return roleResourceRepository.save(roleApp);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        UserApp userApp = userResourceRepo.findByUsername(username);
        RoleApp roleApp = roleResourceRepository.findByName(roleName);
        userApp.getRoleApps().add(roleApp);
    }

    @Override
    public UserApp getUser(String username) {
        log.info("Fetching user {}", username);
        return userResourceRepo.findByUsername(username);
    }

    @Override
    public List<UserApp> getUsers() {
        log.info("Fetching all users");
        return userResourceRepo.findAll();
    }


}
