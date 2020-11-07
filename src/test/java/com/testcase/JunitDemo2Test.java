package com.testcase;

import org.junit.jupiter.api.*;

@DisplayName("junit5测试类")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JunitDemo2Test {


    @BeforeAll
     void before(){
        System.out.println("before");
    }

    @Test
    @DisplayName("测试方法1")
    void fun1(){//junit5在方法前可以不适用修饰符
        System.out.println("junit fun1");
    }

    @Test
    @DisplayName("测试方法2")
    void fun2(){//junit5在方法前可以不适用修饰符
        System.out.println("junit fun2");
    }


    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }
    @AfterEach
    void AfterEach(){
        System.out.println("AfterEach");
    }

    @AfterAll
     void After(){
        //方法必须用static修饰
        System.out.println("After");
    }
}
