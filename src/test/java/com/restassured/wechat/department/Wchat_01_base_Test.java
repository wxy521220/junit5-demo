package com.restassured.wechat.department;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.*;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.基础脚本，执行了创建，修改，查询
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Wchat_01_base_Test {


    private static String access_token;
    private static String departmentId;

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
/*
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
    }*/

    @Test
    @Order(0)
    void addDep(){
        Response addResponse = given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", access_token)
                .body("{\n" +
                        "   \"name\": \"海军部5\",\n" +
                        "   \"parentid\": 1,\n" +
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200)
                .body("errcode", equalTo(0)).extract().response();


        departmentId = addResponse.path("id").toString();
        System.out.println("departmentId"+departmentId);
   }


   @Test
   @Order(1)
    void updDep(){
       System.out.println("departmentId:::"+departmentId);
       Response updResponse = given().contentType("application/json;charset=utf-8")
               .queryParam("access_token", access_token).log().all()
               .body("{\n" +
                       "   \"id\": "+departmentId+",\n" +
                       "   \"name\": \"海军部4after\",\n" +
                       "}\n")
               .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
               .then()
               .log().all()
               .extract().response();
       assertEquals("0",updResponse.path("errcode").toString());


   }


    @Test
    @Order(2)
    void seaDep(){
        given()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+access_token)
                .then().log().all().statusCode(200)
                .body("errcode",equalTo(0));
    }

    @Test
    @Order(3)
    void delDep(){
        Response delResponse = given().contentType("application/json;charset=utf-8")
                .param("access_token", access_token)
                .param("id", departmentId)
                .log().all()
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().all()
                .extract().response();
        assertEquals("0",delResponse.path("errcode").toString());
    }
}































