package com.restassured.wechat.apiobject;

import static io.restassured.RestAssured.given;

public class TokenHelper {


    public static String getToken(){
        String access_token = given()
                .param("corpid","ww8e52f76113da9d96")
                .param("corpsecret","NQkgrW6Qt9AZRq1uFyAziaFebIWlDP6-7RT6r_aCCig")
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .extract().response().path("access_token");
        return access_token;

    }
}
