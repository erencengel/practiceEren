package com.cyber.tests.day9_popupAndAlertsandFrames;

import com.cyber.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class multipleWindows {

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
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("title before switch = " + driver.getTitle());
        String oldWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[.='Opening a new window']/../a")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(oldWindow)) driver.switchTo().window(windowHandle);
        }
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'New')]")).getText().equals("New Window"));
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.xpath("//*[.='Opening a new window']/../a")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("New Window")) break;
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

}
