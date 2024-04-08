package org.example.restapi.restapi.controller;


import org.example.restapi.restapi.controller.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

import static org.apache.coyote.http11.Constants.a;

@RestController
@RequestMapping("/api")
public class RestApiController {


    @GetMapping(path="/hello") //메서드의 이름
    public String hello(){
        //"http://localhost:8080/api/hello"
        return "<xml><message>Hello Spring Boot</message></xml>";

    }


    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}") //{} 안의 변수명과 동일하게 만들어주면 된다.
    public String echo(     
            @PathVariable String message, //path의 {}안에 있는 변수와 동일하게..
            @PathVariable int age,
            @PathVariable boolean isMan
    ){

        System.out.println("echo message is "+message);
        System.out.println("echo age is "+age);
        System.out.println("echo isMan is "+isMan);


        //TODO 대문자로 변환
        message = message.toUpperCase();

        return message;

    }

    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-Month") String issuedMonth,
            @RequestParam String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }


    @GetMapping(path = "/book2")
    public void queryParamDTO(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

}
