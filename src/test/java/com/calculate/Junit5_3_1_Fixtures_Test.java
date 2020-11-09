package com.calculate;

import org.junit.jupiter.api.*;


public class Junit5_3_1_Fixtures_Test {

    @BeforeAll
    static void  BeforeAll(){
        System.out.println("执行BeforeAll");
    }
    @BeforeEach
    void BeforeEach(){
        System.out.println("执行BeforeEach");
    }

    @Test
    void test01(){
        System.out.println("执行test01");
    }
    @Test
    void test02(){
        System.out.println("执行test02");
    }
    @AfterAll
    static void AfterAll(){
        System.out.println("执行AfterAll");
    }
    @AfterEach
     void AfterEach(){
        System.out.println("执行AfterEach");
    }





}
