package com.junit5.calculate;

import org.junit.jupiter.api.*;


public class Junit5_3_2_ChildFixtures_Test extends Junit5_3_1_Fixtures_Test {

    @BeforeAll
    static void  childBeforeAll(){
        System.out.println("执行childBeforeAll");
    }
    @BeforeEach
    void childBeforeEach(){
        System.out.println("执行childBeforeEach");
    }

    @Test
    void childtest01(){
        System.out.println("执行childtest01");
    }
    @Test
    void childtest02(){
        System.out.println("执行childtest02");
    }
    @AfterAll
    static void childAfterAll(){
        System.out.println("执行childAfterAll");
    }
    @AfterEach
     void childAfterEach(){
        System.out.println("执行childAfterEach");
    }





}
