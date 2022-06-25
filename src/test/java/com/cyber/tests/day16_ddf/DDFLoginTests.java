package com.cyber.tests.day16_ddf;

import com.cyber.tests.TestBase;
import com.cyber.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DDFLoginTests extends TestBase {

    ExcelUtil excelUtil;

    @DataProvider
    public Object[][] dataProvider(){
        excelUtil = new ExcelUtil("src/test/resources/Book1.xlsx", "Sheet1");
        String[][] dataArray = excelUtil.getDataArrayWithoutFirstRow();
        return dataArray;
    }

    @Test(dataProvider = "dataProvider")
    public void test1(String username, String password, String aa, String bb){
        driver.get("https://my.cydeo.com/login");
        driver.findElement(By.cssSelector("#Username-Field")).sendKeys(username);
        driver.findElement(By.cssSelector("#Password-Field")).sendKeys(password + Keys.ENTER);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
    }


    @Ignore(value = "it is gonna be run after")
    public void test2(){

    }

}
