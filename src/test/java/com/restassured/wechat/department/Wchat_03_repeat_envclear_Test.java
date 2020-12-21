package com.restassured.wechat.department;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.基础脚本，执行了创建，修改，查询
 * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 * 3、使用时间戳命名法避免入参重复造成的报错。
 * 4、进行了优化，每次方法执行前后都对历史数据进行清理，确保每次执行脚本数据环境一致。
 *
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Wchat_03_repeat_envclear_Test {


    private static String access_token;

    @BeforeAll
    public static void getTest(){
        access_token = given()
                .param("corpid","ww8e52f76113da9d96")
                .param("corpsecret","NQkgrW6Qt9AZRq1uFyAziaFebIWlDP6-7RT6r_aCCig")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .extract().response().path("access_token");
        System.out.println(access_token);


    }
    @BeforeEach
    @AfterEach
    public void clearData(){
        ArrayList<Integer> departmentIds = given()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + access_token)
                .then().log().all().statusCode(200)
                .body("errcode", equalTo(0)).extract().response().path("department.id");

        for(Integer departmentId:departmentIds){
            //不能删除根目录
            if(1==departmentId){
                continue;
            }
            given().contentType("application/json;charset=utf-8")
                    .param("access_token", access_token)
                    .param("id", departmentId)
                    .log().all()
                    .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                    .then().log().all()
                    .extract().response();

        }
    }

    @Test
    @Order(0)
    void addDep(){
        given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", access_token)
                .body("{\n" +
                        "   \"name\": \"海军部new\",\n" +
                        "   \"parentid\": 1,\n" +
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200)
                .body("errcode", equalTo(0)).extract().response();
    }


    @Test
    @Order(1)
    void updDep(){

        Response addResponse = given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", access_token)
                .body("{\n" +
                        "   \"name\": \"海军部add\",\n" +
                        "   \"parentid\": 1,\n" +
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200)
                .body("errcode", equalTo(0)).extract().response();


        String departmentId = addResponse.path("id").toString();

        System.out.println("departmentId:::"+departmentId);
        Response updResponse = given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", access_token).log().all()
                .body("{\n" +
                        "   \"id\": "+departmentId+",\n" +
                        "   \"name\": \"海军部upd\",\n" +
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
        Response addResponse = given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", access_token)
                .body("{\n" +
                        "   \"name\": \"海军部del\",\n" +
                        "   \"parentid\": 1,\n" +
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200)
                .body("errcode", equalTo(0)).extract().response();


        String departmentId = addResponse.path("id").toString();
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































