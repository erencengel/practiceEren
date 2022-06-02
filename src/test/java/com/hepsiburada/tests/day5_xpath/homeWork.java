package com.hepsiburada.tests.day5_xpath;

import com.hepsiburada.utilities.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homeWork {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr");
        driver.manage().window().maximize();
        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sp-cc-accept']")));
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("selenium" + Keys.ENTER);
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.getMessage();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']/../span[1]")).getText().contains("1-48"));
        driver.quit();
    }

}
