package com.restassured;


import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

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

    @Test
    public  void method05(){
        given().body("{\n" +
                " \"ipAddress\" : \"10.77.97.204\",\n" +
                " \"characterSet\" : \"00\",\n" +
                " \"deviceInfo\" : {\n" +
                "  \"channel\": \"PAPP\",\n" +
                "  \"plat\": \"PHONE\",\n" +
                "  \"deviceLanguage\": \"en\",\n" +
                "  \"opSysVer\": \"IOS13.50\",\n" +
                "  \"appTyp\": \"PAPP\",\n" +
                "  \"deviceMod\": \"iPhone 8 Plus\",\n" +
                "  \"clientVer\": \"1.0\",\n" +
                "  \"deviceId\": \"07075588-8119-4E02-AA28-FF4C12AC3225\",\n" +
                "  \"deviceName\": \"iPhone 8 Plus\",\n" +
                "  \"netServiceMer\": \"中国移动\",\n" +
                "  \"opSys\": \"1\",\n" +
                "  \"macAddress\": \"\"\n" +
                " },\n" +
                " \"locationCity\" :\"\" ,\n" +
                " \"logTyp\" : \"05\",\n" +
                " \"logPswd\" : \"\",\n" +
                " \"usrIdTyp\" : \"P\",\n" +
                " \"locationData\" : \"\",\n" +
                " \"emailAddr\" : \"tanganna0522@gmail.com\",\n" +
                " \"browser\" : \"\",\n" +
                " \"authorizeHeadImg\" : \"https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=413056479858619&height=50&width=50&ext=1611901204&hash=AeTkh8ttNTh7Q1PM5Ok\",\n" +
                " \"contentTyp\" : \"text/html\",\n" +
                " \"token\" : \"413056479858619\",\n" +
                " \"networkTyp\" : \"4G\",\n" +
                " \"firstName\" : \"安娜\",\n" +
                " \"locationProv\" :\"\" ,\n" +
                " \"infoVersion\" : \"1.0\",\n" +
                " \"smsCode\" : \"\",\n" +
                " \"lastName\" : \"汤\"\n" +
                "}")
                .post("http://127.0.0.1:8583/gateway/mrpay/UserLogin.do").then().log().all();

    }
    @Test
    public  void method06(){
        given().body("{\n" +
                " \"ipAddress\" : \"10.77.97.204\",\n" +
                " \"characterSet\" : \"00\",\n" +
                " \"deviceInfo\" : {\n" +
                "  \"channel\": \"PAPP\",\n" +
                "  \"plat\": \"PHONE\",\n" +
                "  \"deviceLanguage\": \"en\",\n" +
                "  \"opSysVer\": \"IOS13.50\",\n" +
                "  \"appTyp\": \"PAPP\",\n" +
                "  \"deviceMod\": \"iPhone 8 Plus\",\n" +
                "  \"clientVer\": \"1.0\",\n" +
                "  \"deviceId\": \"07075588-8119-4E02-AA28-FF4C12AC3225\",\n" +
                "  \"deviceName\": \"iPhone 8 Plus\",\n" +
                "  \"netServiceMer\": \"中国移动\",\n" +
                "  \"opSys\": \"1\",\n" +
                "  \"macAddress\": \"\"\n" +
                " },\n" +
                " \"advice\" : \"ajlfjakdjfkajgfkekjgkajkg\",\n" +
                "}")
                .post("http://127.0.0.1:8583/gateway/mrpay/UserFeedBack.do").then().log().all();

    }
    @Test
    public  void method07(){
        given().body("{\n" +
                " \"ipAddress\" : \"10.77.97.204\",\n" +
                " \"characterSet\" : \"00\",\n" +
                " \"deviceInfo\" : {\n" +
                "  \"channel\": \"PAPP\",\n" +
                "  \"plat\": \"PHONE\",\n" +
                "  \"deviceLanguage\": \"en\",\n" +
                "  \"opSysVer\": \"IOS13.50\",\n" +
                "  \"appTyp\": \"PAPP\",\n" +
                "  \"deviceMod\": \"iPhone 8 Plus\",\n" +
                "  \"clientVer\": \"1.0\",\n" +
                "  \"deviceId\": \"07075588-8119-4E02-AA28-FF4C12AC3225\",\n" +
                "  \"deviceName\": \"iPhone 8 Plus\",\n" +
                "  \"netServiceMer\": \"中国移动\",\n" +
                "  \"opSys\": \"1\",\n" +
                "  \"macAddress\": \"\"\n" +
                " },\n" +
                " \"regTyp\" : \"P\",\n" +
                " \"usrId\" : \"1573510451\",\n" +
                " \"firstName\" : \"test1\",\n" +
                " \"lastName\" : \"ove\",\n" +
                " \"accountTyp\" : \"1011\",\n" +
                " \"signInPwd\" : \"521220\",\n" +
                " \"emailAddr\" : \"2460765914@qq.com\",\n" +
                "}")
                .post("http://127.0.0.1:8583/gateway/mrpay/UserRegister.do").then().log().all();

    }




    private static final String REGEX_EMAIL = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+";

    public static Boolean isEmail(String email){
        if(StringUtils.isEmpty(email)){
            return false;
        }
        return Pattern.matches(REGEX_EMAIL,email);
    }


    @Test
    void method8(){
        System.out.println(isEmail("2460765913@qq.com"));
    }

}
