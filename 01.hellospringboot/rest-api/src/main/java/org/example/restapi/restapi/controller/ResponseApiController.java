//package org.example.restapi.restapi.controller;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.example.restapi.restapi.controller.model.UserInfo;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@Controller
//@RequestMapping("/api/v1")
//public class ResponseApiController {
//
//    //http://8080/api/v1
//    //@RequestMapping(method = RequestMethod.GET) //RequestMapping에도 명시해줄 수 있다.
//    //@RequestMapping("") //모든 요청을 받는다.
//    @GetMapping(path = "")//명시적으로 GetMapping을 주는 것이 Best
//    @ResponseBody //컨트롤러 메서드에서 반환되는 데이터를 HTTP 응답 본문에 사용하도록 한다.
//    public ResponseEntity<UserInfo> user(){
//
////        var user = new UserInfo();
//        var response = ResponseEntity.status(HttpStatus.ACCEPTED).header("x-custom","hi").body(user);
//
//
////        user.setUserName("홍길동");
////        user.setEmail("hong@gmail.com");
////        user.setPhoneNumber("010-1234-5678");
////        user.setIsKorean(true);
//        log.info("user :{}",user);
//
//        return response;
//    }
//}
