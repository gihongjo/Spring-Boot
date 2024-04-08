package org.example.restapi.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.restapi.restapi.controller.model.UserInfo;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

    @Autowired //스프링에서 관리하는 bean들 중 자동으로 매핑되는 ObjectMapper들을 가져온다는 어노테이션
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
        var user= new UserInfo("Gildong","01050171678","gildong@gmail.com",true);

        user.setUserName("Gildong");
        user.setEmail("hong@gmail.com");
        user.setPhoneNumber("010-9876-5432");
        user.setIsKorean(true);


        try {
            String json = objectMapper.writeValueAsString(user);


            System.out.println(json);
            //getter 메서드를 모두 지우고 생성자 함수를 사용해서 객체를 만들면 오브젝트 매퍼는 아무것도 받지 못한다.
            //그 이유는 오브젝트 매퍼는 변수에 매칭되는 것이 아닌 get으로 시작되는 메소드에 매칭되는 것이기 때문이다.
            //오브젝트 매핑은 직렬화를 해줄 때 변수에 따라 직렬화를 하는 것 이 아닌 get~메서드를 따라 직렬화를 한다.
            //또한 매핑 시 get이후의 글자를 사용한다. 예를들어 getIsKorean = true이라면 매핑된 정보는 "isKorean": true 이다.


var dto=objectMapper.readValue(json, UserInfo.class);
System.out.println(dto);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
