package org.example.restapi.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.restapi.restapi.controller.model.UserInfo;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

//
//    @PutMapping("/put")
//    public void put(@RequestBody UserInfo userInfo){
//    log.info("Request : {}",userInfo);
//    }

    @DeleteMapping(path = {"/user/{userName}/delete",
            "/user/{userName}/del"
    })//중괄호를 통해 여러 주소를 매핑해줄 수 있다.
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name: {}",userName);
    }

}
