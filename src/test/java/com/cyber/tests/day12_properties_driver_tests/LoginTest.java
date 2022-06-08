package com.cyber.tests.day12_properties_driver_tests;

import com.cyber.tests.TestBase;
import com.cyber.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void test(){
        //driver.get(ConfigurationReader.get("url")); good example
        driver.get("https://www.google.com");
    }

}
