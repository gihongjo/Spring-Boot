package org.example.restapi.restapi.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //SnakeCase로 변환
public class UserInfo{
    private String userName,phoneNumber, email;
    private Boolean isKorean; //boolean 타입의 is 라는 시리즈는 isKorean의 set메서드가 SetisKorean 이 아닌 setKorean으로 설정된다.
                                //그렇기 때문에 레퍼런스 타입인 Boolean 타입을 사용해야한다.

    @JsonIgnore //원하지 않는 정보를 오브젝트 매핑 할 때 Json ignore을 붙이면 무시한다.
    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("user_email") //오브젝트 매핑 시 명시적으로 해당 변수의 이름을 바꿀수 있다.
    public String getEmail() {
        return email;
    }

    public Boolean getIsKorean() {
        return isKorean;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
}
