package com.paramtest;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamTest {

    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void param(int aa){
        System.out.println(aa);
    }
}
