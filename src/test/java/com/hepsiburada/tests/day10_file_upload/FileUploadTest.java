package com.hepsiburada.tests.day10_file_upload;

import com.hepsiburada.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));

        //If choosefile element has a tag which is "file" and it equals to "file" than you can use "sendkeys" method which is a pretty fine selenium feature

        chooseFile.sendKeys("/Users/eren.cengel/Desktop/file.txt");
        driver.findElement(By.cssSelector("#file-submit")).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        //target path is:
        ///Users/eren.cengel/IdeaProjects/practiceEren/src/test/resources/textfile.txt
        //we have created it as a dynamic way by using system.getproperty

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath + "/" + filePath;
        System.out.println("fullPath = " + fullPath);

        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys(fullPath);
        driver.findElement(By.cssSelector("#file-submit")).click();

    }

}
