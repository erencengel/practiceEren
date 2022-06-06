package com.cyber.tests.day8_typesOfElements;

import com.cyber.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dropDown {

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
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        Select select = new Select(driver.findElement(By.cssSelector("#state")));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Alabama", "lets compare");
        driver.findElement(By.cssSelector("#dropdownMenuLink")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector(".dropdown-item"));
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
    }
}
