package com.cyber.tests.day5_xpath;

import com.cyber.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class prac {

   @Test
    public void test1(){

       WebDriver driver;
       driver = Driver.get();
       driver.manage().window().maximize();
       driver.switchTo().alert().accept();
       driver.switchTo().frame(driver.findElement(By.xpath("test")));
       driver.switchTo().defaultContent();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.getWindowHandle();
       Set<String> windowHandles = driver.getWindowHandles();
       Select select = new Select(driver.findElement(By.xpath("test")));
       select.getFirstSelectedOption();
       Actions actions = new Actions(driver);
       WebDriverWait webDriverWait = new WebDriverWait(driver, 7);
       webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("test"))));
       JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
       javascriptExecutor.executeScript("test");

   }

}
