package com.junit5.suite;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "com.junit5.testcase1","com.junit5.testcase2"
})
@IncludePackages(
        "com.junit5.testcase1"
)

public class Junit5SuiteTest {

}
