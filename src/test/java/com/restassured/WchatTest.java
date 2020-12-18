package com.restassured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WchatTest {


    private static String access_token;

   @BeforeAll
    public static void getTest(){
         access_token = given()
                 .param("corpid","ww8e52f76113da9d96")
                //.param("corpsecret","4eRKJ-_kzAC4R-XsPisRyoM_v-7NzhgH9pqzjthZXdg")
                .param("corpsecret","NQkgrW6Qt9AZRq1uFyAziaFebIWlDP6-7RT6r_aCCig")
                 //.params("corpid","ww8e52f76113da9d96","corpsecret","4eRKJ-_kzAC4R-XsPisRyoM_v-7NzhgH9pqzjthZXdg")
                //.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ww8e52f76113da9d96&corpsecret=4eRKJ-_kzAC4R-XsPisRyoM_v-7NzhgH9pqzjthZXdg")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                 .then()
                .extract().response().path("access_token");
        System.out.println(access_token);


        //ww8e52f76113da9d96
        //4eRKJ-_kzAC4R-XsPisRyoM_v-7NzhgH9pqzjthZXdg
    }

    @Test
    void postMethod(){
        given().contentType("application/json;charset=utf-8")
                .queryParam("access_token",access_token)
                //命名路径参数
                .pathParam("send","send")
                .body("{\n" +
                "   \"touser\" : \"@all\",\n" +
                "   \"msgtype\" : \"text\",\n" +
                "   \"agentid\" : 1000002,\n" +
                "   \"text\" : {\n" +
                "       \"content\" : \"欢迎光临。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"\n" +
                "   },\n" +
                "}")
                //未命名路径参数
                .post("https://qyapi.weixin.qq.com/cgi-bin/{message}/{send}","message")
                .then().log().all();
    }

    @Test
    void addDep(){
       given().contentType("application/json;charset=utf-8")
        .queryParam("access_token",access_token)
               .body("{\n" +
                       "   \"name\": \"运营部\",\n" +
                       "   \"parentid\": 1,\n" +
                       "}")
               .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
               .then().log().all().statusCode(200)
               .body("errcode",equalTo(0));
   }
    @Test
    void seaDep(){
       given()
              .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+access_token)
               .then().log().all().statusCode(200)
               .body("errcode",equalTo(0));
   }
}
