package com.cyber.tests.day13_pom;

import com.cyber.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice extends TestBase {

    @Test
    public void negativeTest(){

        String expectedTitle = "(20+) Facebook";

        extentLogger = report.createTest("negativeTest");
        extentLogger.info("Go to the login page of facebook");
        driver.get("https://www.facebook.com");
        extentLogger.info("enter username");
        driver.findElement(By.cssSelector("#email")).sendKeys("erencengel@gmail.com");
        extentLogger.info("enter password");
        driver.findElement(By.cssSelector("#pass")).sendKeys("06050425");
        extentLogger.info("click on login button");
        driver.findElement(By.xpath("//button[@valu='1']")).click();
        extentLogger.info("verify page title");
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        extentLogger.info("negative test has passed");
    }

    @Test
    public void positiveTest(){

        String expectedTitle = "(+20) Facebook";

        extentLogger = report.createTest("positiveTest");
        extentLogger.info("Go to the login page of facebook");
        driver.get("https://www.facebook.com");
        extentLogger.info("enter username");
        driver.findElement(By.cssSelector("#email")).sendKeys("erencengel@gmail.com");
        extentLogger.info("enter password");
        driver.findElement(By.cssSelector("#pass")).sendKeys("06050425");
        extentLogger.info("click on login button");
        driver.findElement(By.xpath("//button[@value='1']")).click();
        extentLogger.info("verify page title");
        try {
            Thread.sleep(3000);
        }catch (Exception exception){
            exception.getMessage();
        }
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        extentLogger.info("negative test has passed");

    }

}
