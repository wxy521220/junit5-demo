package com.testcase2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitDemo2Test {

    @Test
    @DisplayName("测试方法6.1")
    void fun1(){//junit5在方法前可以不适用修饰符
        System.out.println("测试方法6.1");
    }

    @Test
    @DisplayName("测试方法6.2")
    void fun2(){//junit5在方法前可以不适用修饰符
        System.out.println("测试方法6.2");
    }


}
