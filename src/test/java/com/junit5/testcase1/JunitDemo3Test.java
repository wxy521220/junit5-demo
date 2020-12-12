package com.junit5.testcase1;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitDemo3Test {

    @Test
    @Order(3)
    void fun3_1(){//junit5在方法前可以不适用修饰符
        System.out.println("测试方法3.1");
    }

    @Test
    @Order(1)
    void fun3_2(){//junit5在方法前可以不适用修饰符
        System.out.println("测试方法3.2");
    }


}
