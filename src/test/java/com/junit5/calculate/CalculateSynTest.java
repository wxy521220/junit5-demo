package com.junit5.calculate;

import com.demo.Calculate;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculateSynTest {


   @RepeatedTest(10)
    void count_2Test(){
        int result=Calculate.countSyn(1);
       System.out.println(result);
   }




}
