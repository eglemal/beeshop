package com.example.eshop_backend;

import com.example.eshop_backend.user.User;

public class TestUtil {

    public static User createValidUser() {
        User user = new User();
        user.setUsername("test-username");
        user.setEmail("test@email");
        user.setPassword("P4ssword");
        return user;
    }

    public static User createValidUser(String username) {
        User user = createValidUser();
        user.setUsername(username);
        return user;
    }
}
