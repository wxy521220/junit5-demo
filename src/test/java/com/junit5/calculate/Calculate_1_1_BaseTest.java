package com.junit5.calculate;

import com.demo.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Calculate_1_1_BaseTest {
    @BeforeEach
    void BeforeEach(){
        Calculate.clear();
    }

    @Test
    void addTest(){
        int result01= Calculate.add(2,4);
        System.out.println(result01);
    }
    @Test
    void subTest(){
        int result01= Calculate.subtract(4,2);
        System.out.println(result01);
    }
    @Test
    void multTest(){
        int result01= Calculate.multiply(2,4);
        System.out.println(result01);
    }
    @Test
    void divTest(){
        int result01= Calculate.divide(4,2);
        System.out.println(result01);
    }

   @Test
    void countTest(){
       System.out.println("Calculate.result-->"+Calculate.result);
        int result=Calculate.count(1);
       System.out.println("Calculate.result2-->"+Calculate.result);
       result=Calculate.count(1);
       System.out.println("Calculate.result3-->"+Calculate.result);
       result=Calculate.count(1);
       System.out.println("Calculate.result4-->"+Calculate.result);
       result=Calculate.count(1);
       result=Calculate.count(1);
       assertEquals(5,result);
   }





}
