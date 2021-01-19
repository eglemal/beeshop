package com.example.eshop_backend.user;

import com.example.eshop_backend.error.ApiError;
import com.example.eshop_backend.shared.CurrentUser;
import com.example.eshop_backend.user.vm.UserVM;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

//    @PostMapping("/login")
//    Map<String, Object> handleLogin(@CurrentUser User loggedInUser) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("id", loggedInUser.getId());
//        params.put("username", loggedInUser.getUsername());
//        params.put("password", loggedInUser.getPassword());
//        params.put("isLoggedIn", true);
//        return params;
////        return Collections.singletonMap("id", loggedInUser.getId());
//    }

    @PostMapping("/api/1.0/login")
    UserVM login(@CurrentUser User loggedInUser) {
        return new UserVM(loggedInUser);
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    ApiError handleAccessDeniedException() {
//        return new ApiError(401, "Access Error", "/api/1.0/login");
//    }
}
