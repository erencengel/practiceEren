package com.cyber.tests.day10_actionsJs;

import com.cyber.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void clickWithJS1(){
        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click(0)",driver.findElement(By.xpath("//a[.='Dropdown']")));
    }

    @Test
    public void clickWithJS2(){
        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//a[.='Web Tables']")).click();
        //javascriptExecutor.executeScript("arguments[0].click(0)",driver.findElement(By.xpath("//a[.='Web Tables']")));
    }

    @Test
    public void sendTextToDisabledButton(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement webElement = driver.findElement(By.cssSelector("form#input-example>input"));
        String text = "Hello disabled button";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", webElement);
    }

    @Test
    public void scrollUpAndDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(0,20)");
            Thread.sleep(1000);
        }

        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(0,-20)");
            Thread.sleep(1000);
        }
    }

    @Test
    public void scrollRightAndLeft() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(20,0)");
            Thread.sleep(1000);
        }

        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(-20,0)");
            Thread.sleep(1000);
        }
    }

    @Test
    public void reachSpecificElement(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement webElement = driver.findElement(By.xpath("//a[.='Web Tables']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

}
