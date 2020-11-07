package com.testcase;

import org.junit.jupiter.api.*;

@DisplayName("junit5测试类")
public class JunitDemo1Test {


    @BeforeAll
    static void before(){
        System.out.println("before");
    }

    @Test
    @DisplayName("测试方法1")
    @RepeatedTest(3)
    void fun1(){//junit5在方法前可以不适用修饰符
        System.out.println("junit fun1");
    }

    @Test
    @DisplayName("测试方法2")
    void fun2(){//junit5在方法前可以不适用修饰符
        System.out.println("junit fun2");
    }

    //Disabled相当于junit4中的Ignore
    @Test
    @Disabled
    @DisplayName("测试忽略")
    void fun3(){
        System.out.println("junit fun3");
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
    static void After(){
        //方法必须用static修饰
        System.out.println("After");
    }
}
