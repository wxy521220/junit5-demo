package com.restassured;


import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CaseTest {


    @Test
    public  void method01(){
        given()
                .get("https://www.baidu.com")
                .then()
                .statusCode(200)
                .body("",hasItems())
                .log().all();
    }
    @Test
    public  void method02(){
        String asString = given()
                .get("https://www.baidu.com")
                .asString();
        System.out.println(asString);
    }
    @Test
    public  void method03(){
        String asString = given()
                .get("https://www.baidu.com")
                .asString();
        System.out.println(asString);
    }
    @Test
    public  void responseTest(){
        Response response = get("http://www.baidu.com");
        ResponseBody body = response.getBody();
        String statusLine = response.getStatusLine();
        int statusCode = response.getStatusCode();
        System.out.println(statusLine);
        System.out.println(statusCode);
        get("http://www.baidu.com").then().assertThat().statusCode(200).log().status();

        //ww8e52f76113da9d96
        //4eRKJ-_kzAC4R-XsPisRyoM_v-7NzhgH9pqzjthZXdg
    }


    @Test
    public  void method04(){
        given()
                .get("http://localhost:8888/assetApp/login")
                .then()
                .statusCode(200)
                .body("lotto.winners.winnerId",hasItems(23,54))
                .body("lotto.lottoId",equalTo(5))
                .log().all();
    }
}
