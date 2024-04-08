package org.example.restapi.restapi.controller.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor //모든 파라미터를 받는 기본 생성자 생성해주는 어노테이션
@NoArgsConstructor //어떤 파라미터도 받지 않는 기본 생성자 생성해주는 어노테이션
public class BookQueryParam {

    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

}
