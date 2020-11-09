package com.calculate;

import com.demo.Calculate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Calculate_2_1_AssertTest {
    @BeforeEach
    void BeforeEach(){
        Calculate.clear();
    }

    @Test
    void addTest(){
        int result01= Calculate.add(2,4);
        System.out.println(result01);
        assertEquals(6,result01);
    }
    @Test
    void subTest(){
        int result01= Calculate.subtract(4,2);
        System.out.println(result01);
        assertEquals(2,result01);
    }
    @Test
    void multTest(){
        int result01= Calculate.multiply(2,4);
        System.out.println(result01);
        assertEquals(8,result01);
    }
    @Test
    void divTest(){
        int result01= Calculate.divide(4,2);
        System.out.println(result01);
        assertEquals(2,result01);
    }

    /*
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
       }*/
    @Test
    void countSynTest(){
        System.out.println("Calculate.result-->"+Calculate.result);
        int result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        assertEquals(5,result);
    }


    @Test
    void assertTest(){
        int result01= Calculate.add(2,4);
        System.out.println(result01);
        Object aaa=null;
        Object bbb=new Object();
        int a=129;
        int b=129;
        int c=127;
        int d=127;
        int Array1[]={1,2,3};
        int Array2[]={1,2,4};

        assertAll("测试常用断言方法：",
                ()->assertEquals(6,result01),
                ()->assertNotEquals(7,result01),
                ()->assertEquals("加法结果不相等",7,result01),
                ()->Assertions.assertTrue(1>2),
                ()->Assertions.assertTrue(1>2,"1>2为真"),
                ()->Assertions.assertFalse(2>1,"2>1为假"),
                ()->Assertions.assertNull(bbb,"当前对象为null"),
                ()->Assertions.assertNotNull(aaa,"当前对象不是null"),
                ()->Assertions.assertSame(a,b,"a与b引用相等"),
                ()->Assertions.assertNotSame(c,d,"a与b引用不相等"),
                ()->Assertions.assertArrayEquals(Array1,Array2,"两个数组相等"),
                ()->Assertions.fail()

        );



    }


}
