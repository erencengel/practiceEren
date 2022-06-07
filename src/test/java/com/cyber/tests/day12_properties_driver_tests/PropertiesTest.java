package com.cyber.tests.day12_properties_driver_tests;

import com.cyber.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println(browser);
    }



}
