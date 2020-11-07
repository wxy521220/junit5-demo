package com.calculate;

import com.demo.Calculate;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculateTest {

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
                ()->assertEquals(6,result02),
                ()->assertEquals(9,result03)
        );
    }
}
