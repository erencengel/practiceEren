package com.cyber.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataPRovider {

    @DataProvider
    public Object [][] testData(){
        String[][] data = {
                {"Person Of Interest ","10"},
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"The Office","8"},
                {"Friends","7"},
                {"WestWorld","10"},
                {"Gotham","9"}
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void test1(String tvshow, String rating){
        System.out.println("Tv show: " + tvshow + " has rating " + rating);
    }

}
