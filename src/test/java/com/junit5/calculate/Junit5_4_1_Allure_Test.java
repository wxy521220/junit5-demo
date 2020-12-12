package com.junit5.calculate;

import com.demo.Calculate;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@Epic("计算器项目")
@Feature("冒烟测试")
public class Junit5_4_1_Allure_Test {
    @BeforeEach
    void BeforeEach(){
        Calculate.clear();
    }

    @Test
    @Description("计算器-Description")
    @Story("计算器-addTest")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("")
    @Link(name = "Link 社区贴" ,type = "mylink", url ="https://ceshiren.com/t/topic/7718")
    void addTest(){
        int result01= Calculate.add(2,4);
        System.out.println(result01);
        Allure.addAttachment("pic","image/png",this.getClass().getResourceAsStream("/pic01.png"),".png");
        assertEquals(7,result01);
    }
    @Test
    @Description("计算器-Description")
    @Story("计算器-subTest")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("")
    @Link(name = "Link 社区贴" ,type = "mylink", url ="https://ceshiren.com/t/topic/7718")
    void subTest(){
        int result01= Calculate.subtract(4,2);
        System.out.println(result01);
        assertEquals(2,result01);
    }
    @Test
    void multTest(){
        int result01= Calculate.multiply(2,4);
        System.out.println(result01);
        assertEquals(9,result01);
    }
    @Test
    void divTest(){
        int result01= Calculate.divide(4,2);
        System.out.println(result01);
        assertEquals(2,result01);
    }

    @RepeatedTest(10)
    void countSynTest() throws InterruptedException {
        System.out.println("Calculate.result-->"+Calculate.result);
        int result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        result=Calculate.countSyn(1);
        Thread.sleep(1000);
        assertEquals(5,result);
    }




}
