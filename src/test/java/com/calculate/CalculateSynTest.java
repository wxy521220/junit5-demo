package com.calculate;

import com.demo.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculateSynTest {


   @RepeatedTest(10)
    void count_2Test(){
        int result=Calculate.countSyn(1);
       System.out.println(result);
   }




}
