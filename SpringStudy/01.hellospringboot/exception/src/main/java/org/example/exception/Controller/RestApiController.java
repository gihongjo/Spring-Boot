    package org.example.exception.Controller;


    import lombok.extern.slf4j.Slf4j;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @Slf4j
    @RestController
    @RequestMapping(path = "api")
    public class RestApiController {

        @GetMapping(path = "/hello")
        public void hello(){

            throw new NumberFormatException("Number format exception");
        }



        @ExceptionHandler(value = NumberFormatException.class)
        public ResponseEntity outOfBoundery(NumberFormatException e){
            log.error("RestApiController",e );

            return ResponseEntity.ok().build();
        }

    }

