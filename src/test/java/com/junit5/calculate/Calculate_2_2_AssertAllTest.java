package com.junit5.calculate;

import com.demo.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Calculate_2_2_AssertAllTest {
    @BeforeEach
    void BeforeEach(){
        Calculate.clear();
    }
/*
断言方式：
 */
    @Test
    void addTest(){
        int result01= Calculate.add(2,4);
        int result02= Calculate.add(2,5);
        int result03= Calculate.add(2,6);
        System.out.println(result01);
        System.out.println(result02);
        System.out.println(result03);
        assertAll("验证加法结果",
                ()->assertEquals(6,result01),
                ()->assertEquals(7,result02),
                ()->assertEquals(8,result03)
        );
    }




}
