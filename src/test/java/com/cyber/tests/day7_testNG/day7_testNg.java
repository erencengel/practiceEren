package com.cyber.tests.day7_testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day7_testNg {

    @BeforeMethod
    public void setUp(){
        System.out.println("Opening Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing");
    }

    @Test
    public void test1(){
        System.out.println("first test is executed");
    }

}
