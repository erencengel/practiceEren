package com.hepsiburada.tests.day9_popupAndAlertsandFrames;

import com.hepsiburada.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");
        driver.switchTo().parentFrame();
        System.out.println("driver.findElement(By.xpath(\"//h3[contains(text(),'Editor')]\")).getText() = " + driver.findElement(By.xpath("//h3[contains(text(),'Editor')]")).getText());
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'L')]")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'M')]")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'R')]")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'B')]")).getText());
    }



}
