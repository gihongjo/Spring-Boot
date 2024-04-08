package org.example.restapi.restapi.controller;

import org.apache.catalina.User;
import org.example.restapi.restapi.controller.model.BookRequest;
import org.example.restapi.restapi.controller.model.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {


    @PostMapping("/postUser")
    public UserInfo userPost(
            @RequestBody UserInfo userinfo
            ){

        System.out.println(userinfo);
        return userinfo;
    }
}
