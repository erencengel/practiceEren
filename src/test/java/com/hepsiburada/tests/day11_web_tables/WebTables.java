package com.hepsiburada.tests.day11_web_tables;

import com.hepsiburada.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        System.out.println(driver.findElement(By.cssSelector("table#table1")).getText());
    }

    @Test
    public void getAllHeaders(){
        //how many columns we have
        List<WebElement> elements = driver.findElements(By.cssSelector("table#table1>thead>tr>th"));
        System.out.println("elements.size() = " + elements.size());
        //number of rows
        List<WebElement> elements1 = driver.findElements(By.cssSelector("table#table1>tbody>tr"));
        System.out.println("elements1.size() = " + elements1.size());
    }

    @Test
    public void getRow(){
        //print second row information
        List<WebElement> elements1 = driver.findElements(By.cssSelector("table#table1>tbody>tr"));
        System.out.println("elements1.get(1).getText() = " + elements1.get(1).getText());
        getRowBasedOnIndexNumber(3);

        for (WebElement webElement : elements1) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }

        for(int i=0; i<elements1.size(); i++){

        }
    }

    public void getRowBasedOnIndexNumber(int a){
        List<WebElement> elements1 = driver.findElements(By.cssSelector("table#table1>tbody>tr"));
        System.out.println("elements1.get(a).getText() = " + elements1.get(a).getText());
    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> elements = driver.findElements(By.xpath("(//table[@id='table1']/tbody/tr)[1]/td"));
        for (int i=1;i<=elements.size();i++){
            System.out.println(driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr)[1]/td[" + i + "]")).getText());
        }
    }

    @Test
    public void getAllCellInRows(){
        List<WebElement> out = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<WebElement> in = driver.findElements(By.xpath("(//table[@id='table1']/tbody/tr)[1]/td"));

        for (int j = 1; j <= out.size(); j++) {
            for (int i = 1; i <= in.size(); i++) {
                System.out.println(driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr)[" + j + "]/td[" + i + "]")).getText());
            }
        }
    }

    public void getAllCellInRowsWithParameters(int j, int i){
        List<WebElement> out = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<WebElement> in = driver.findElements(By.xpath("(//table[@id='table1']/tbody/tr)[1]/td"));
        System.out.println(driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr)[" + j + "]/td[" + i + "]")).getText());
    }

    @Test
    public void getSpecificCell(){
        getAllCellInRowsWithParameters(3,5);
    }

}
