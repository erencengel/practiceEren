package com.cyber.tests.day10_actionsJs;

import com.cyber.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.figure"));
        for(int i=1; i<4;i++){
            actions.moveToElement(driver.findElement(By.cssSelector("div.figure:nth-of-type(+" + i + ")"))).perform();
            Assert.assertTrue(driver.findElement(By.xpath("(//a[.='View profile'])[" + i + "]")).getText().equals("View profile"));
            Thread.sleep(3000);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"))));
        driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droptarget"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h4[.='cursorOffset']")));

        Thread.sleep(4000);


        new WebDriverWait(driver,7).until(ExpectedConditions.elementToBeClickable(draggable));
        new Actions(driver).dragAndDrop(draggable,dropTarget).perform();
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"))));
        driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropTarget = driver.findElement(By.id("droptarget"));

        //congrats to yourself, it is working anymore :)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,20)");

        }
        new Actions(driver).moveToElement(draggable).clickAndHold().moveToElement(dropTarget).pause(3000).release().perform();
        Thread.sleep(3000);
    }

}
