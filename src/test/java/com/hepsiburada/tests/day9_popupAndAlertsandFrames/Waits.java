package com.hepsiburada.tests.day9_popupAndAlertsandFrames;

import com.hepsiburada.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Waits {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector("#username"))
        ));
        driver.findElement(By.cssSelector("#username")).sendKeys("Aslıhan Zeynep");
    }
}
