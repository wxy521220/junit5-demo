package com.restassured.wechat.department;

import com.restassured.wechat.apiobject.DepartMentObject;
import com.restassured.wechat.apiobject.TokenHelper;
import com.utils.FakerUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1.基础脚本，执行了创建，修改，查询
 * 2、进行了优化，方法间进行解耦，每个方法可以独立行
 * 3、使用时间戳命名法避免入参重复造成的报错。
 * 4、进行了优化，每次方法执行前后都对历史数据进行清理，确保每次执行脚本数据环境一致。
 * 5、进行了优化，对脚本进行了分层，减少了重复代码，提高了代码复用率，并减少了维护成本。
 * 6、进行了优化，因为要覆盖不同的入参组合，以数据驱动的方式将入参从代码剥离。
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Wchat_05_param_Test {

    private static String access_token;


    @BeforeAll
    public static void getToken(){
         access_token = TokenHelper.getToken();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/department.csv")
    void addDep(String name){
        Response response=DepartMentObject.createDep(name,access_token);
        String errCode=response.path("errcode").toString();
        assertEquals("0",errCode);
   }


   @Test
   @Order(1)
    void updDep(){
       String departmentId=DepartMentObject.createDep(access_token);
       String newName="newName"+ FakerUtils.getTimeStamp();
       Response updResponse=DepartMentObject.updateDep(departmentId,newName,access_token);
       assertEquals("0",updResponse.path("errcode").toString());


   }


    @Test
    @Order(2)
    void seaDep(){
        Response response=DepartMentObject.searchDep(access_token);
        assertEquals("0",response.path("errcode").toString());

    }

    @Test
    @Order(3)
    void delDep(){
        String departmentId=DepartMentObject.createDep(access_token);
        Response delResponse=DepartMentObject.deleteDep(departmentId,access_token);
        assertEquals("0",delResponse.path("errcode").toString());
    }
}































