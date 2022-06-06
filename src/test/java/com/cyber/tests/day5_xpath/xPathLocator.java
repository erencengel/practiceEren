package com.cyber.tests.day5_xpath;

import com.cyber.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xPathLocator {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.xpath("//button[@onclick='button2()']")).click();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            // no need to action
        }
        driver.quit();
    }

}
