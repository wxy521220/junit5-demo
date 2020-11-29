package com.paramtest;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParamTest {

    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void param(int aa){
        System.out.println(aa);
    }

    @ParameterizedTest(name = "[{index}] TimeUnit: {arguments}")
    @EnumSource(TimeUnit.class)
    void testTimeUnitMinimumNanos(TimeUnit unit) {
        assertTrue(unit.toMillis(2000000L) > 1);
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"SECONDS", "MINUTES"})
    void testTimeUnitJustSecondsAndMinutes(TimeUnit unit) {
        assertTrue(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
        assertFalse(EnumSet
                .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.EXCLUDE, names = {"SECONDS", "MINUTES"})
    void testTimeUnitExcludingSecondsAndMinutes(TimeUnit unit) {
        assertFalse(EnumSet.of(TimeUnit.SECONDS, TimeUnit.MINUTES).contains(unit));
        assertTrue(EnumSet
                .of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.MATCH_ALL, names = ".*SECONDS")
    void testTimeUnitIncludingAllTypesOfSecond(TimeUnit unit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES).contains(unit));
        assertTrue(EnumSet
                .of(TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.NANOSECONDS,
                        TimeUnit.MICROSECONDS).contains(unit));
    }



}
