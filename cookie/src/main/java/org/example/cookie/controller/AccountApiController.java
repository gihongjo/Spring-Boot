package org.example.cookie.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.cookie.model.UserLoginRequest;
import org.example.cookie.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(

            @RequestBody
            UserLoginRequest userLoginRequest,
            HttpServletResponse httpServletResponse

    ){

        userService.login(userLoginRequest,httpServletResponse);
    }

}
