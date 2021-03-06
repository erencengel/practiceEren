package com.cyber.tests.day12_properties_driver_tests;

import com.cyber.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    //SINGLETON
    //in different test cases, only one driver is used

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }


    @Test
    public void test2(){
        WebDriver driver = Driver.get();
        driver.get("https://www.google.com");
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");
    }

}
