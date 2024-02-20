package com.example.demo_session_upload.service;

import com.example.demo_session_upload.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();

        User user1 = User.builder()
                .username("popo")
                .password("hello1")
                .build();
    }


    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            User user = User.builder().username(username).password(password).build();
            users.put(username, user);
        }
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
