package com.hepsiburada.tests.day8_typesOfElements;

import com.hepsiburada.utilities.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class listOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for (WebElement element : elements) {
            System.out.println("element.getAttribute(\"outerHTML\") = " + element.getAttribute("outerHTML"));
        }
        for (WebElement element : elements) {
            System.out.println("element.getAttribute(\"innerHTML\") = " + element.getAttribute("innerHTML"));
        }
    }

    @Test
    public void test2(){
        System.out.println("This is the second test case");
    }

    @Test
    public void test3(){
        System.out.println("This is the third test case");
    }

}
