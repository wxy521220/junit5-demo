package com.restassured.wechat.apiobject;

import com.utils.FakerUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartMentObject {


    public static  Response createDep(String name,String accessToken){
        Response addResponse = given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", accessToken)
                .body("{\n" +
                        "   \"name\": \"" + name + "\",\n" +
                        "   \"parentid\": 1,\n" +
                        "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .extract().response();
        return addResponse;
    }
    public static String createDep(String accessToken){
        String name="name"+ FakerUtils.getTimeStamp();
        Response addResponse = createDep(name,accessToken);
        String departmentId = addResponse.path("id").toString();
        return departmentId;

    }


    public static Response updateDep(String departmentId,String newName,String accessToken){
        System.out.println("departmentId:::"+departmentId);
        Response updResponse = given().contentType("application/json;charset=utf-8")
                .queryParam("access_token", accessToken).log().all()
                .body("{\n" +
                        "   \"id\": "+departmentId+",\n" +
                        "   \"name\": \""+newName+"\",\n" +
                        "}\n")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
                .then()
                .log().all()
                .extract().response();
        return updResponse;

    }

   public static Response deleteDep(String departmentId,String accessToken){
        Response delResponse = given().contentType("application/json;charset=utf-8")
                .param("access_token", accessToken)
                .param("id", departmentId)
                .log().all()
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().all()
                .extract().response();

        return delResponse;
    }


    public static Response searchDep(String accessToken){
        Response response = given()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + accessToken)
                .then().log().all()
               .extract().response();
        return response;
    }

}
