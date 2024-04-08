package org.example.exception.exception;


import lombok.extern.slf4j.Slf4j;
import org.example.exception.model.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackages = "org.example.exception.Controller")   //RestApi가 사용되는 곳에 예외가 발생하는 것을 감지하는 어노테이션이다.
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class}) //어떠한 예외를 잡을지 지정한다. 여기서는 모든 예외를 잡는다.
    public ResponseEntity exception(Exception e){

        log.error("RestApuExceptionHandler",e); //Logging Error

        return ResponseEntity.status(200).build(); // Body가 없는 정상응답 200을 반환

    }


    @ExceptionHandler(value = {IndexOutOfBoundsException.class}) //특정한 예외를 잡는다. 여기서는 IndexOutOfBoundsException 에러를 잡는다.
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e //해당 예외를 받는다.
    ){
        log.error("IndexOutOfBoundsException",e); //Logging Error

        return ResponseEntity.status(200).build(); // Body가 없는 정상응답 200을 반환

    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Api<Object>> noSuchElement(
            NoSuchElementException e
    ){
        log.error("",e);

        var response= Api.builder().resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

}
