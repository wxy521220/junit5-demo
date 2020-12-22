package com.restassured.wechat.apiobject;

import com.utils.FakerUtils;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * 成员管理
 */

public class UserObject {

    /**
     * 创建成员
     * @param accessToken
     * @param userid
     * @param name
     * @return
     */
    public static Response createUser(String accessToken,String userid,String name){
        Response response = given()
                .queryParam("access_token", accessToken)
                .body("{\n" +
                        "    \"userid\": \""+userid+"\",\n" +
                        "    \"name\": \""+name+"\",}")
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then()
                .log().all()
                .extract().response();
        return response;
    }
    public static String createUser(String accessToken){
        String name="name"+FakerUtils.getTimeStamp()+Thread.currentThread().getId();
        String userid="userid"+FakerUtils.getTimeStamp()+Thread.currentThread().getId();
        createUser(accessToken,userid,name);
        return userid;
    }

    /**
     * 读取成员
     * @param accessToken
     * @param userid
     * @return
     */
    public static Response getUser(String accessToken,String userid){
        Response response = given()
                .param("access_token", accessToken)
                .param("userid",userid)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/get")
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    /**
     * 更新成员
     * @param accessToken
     * @param userid
     * @param newName
     * @return
     */
    public static Response updateUser(String accessToken,String userid,String newName){
        Response response = given()
                .queryParam("access_token", accessToken)
                .body("{\n" +
                        "    \"userid\": \""+userid+"\",\n" +
                        "    \"name\": \""+newName+"\",}")
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    /**
     * 删除成员
     * @param accessToken
     * @param userid
     * @return
     */
    public static Response deleteUser(String accessToken,String userid){
        Response response = given()
                .param("access_token", accessToken)
                .param("userid",userid)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/delete")
                .then()
                .log().all()
                .extract().response();
        return response;
    }

    /**
     * 批量删除成员
     * @param accessToken
     * @param useridlist
     * @return
     */
    public static Response batchdeleteUser(String accessToken, List<String> useridlist){
        Response response = given()
                .queryParam("access_token", accessToken)
                .body("{\n" +
                        "    \"useridlist\": \""+useridlist+"\",}")
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete")
                .then()
                .log().all()
                .extract().response();
        return response;
    }






}
