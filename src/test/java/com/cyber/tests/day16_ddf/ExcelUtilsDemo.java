package com.cyber.tests.day16_ddf;

import com.cyber.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){
        //Create an object from ExcelUtil class
        //it accepts two argument
        // 1- location of the path
        // 2- sheet that we want to open

        String path1 = System.getProperty("user.dir/") + "src/test/resources/Book1.xlsx";
        String path = "src/test/resources/Book1.xlsx";
        ExcelUtil excelUtil = new ExcelUtil(path, "Sheet1");
        System.out.println("excelUtil.columnCount() = " + excelUtil.columnCount());
        System.out.println("excelUtil.getCellData(0,0) = " + excelUtil.getCellData(0, 0));
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());
        System.out.println("excelUtil.getColumnsNames() = " + excelUtil.getColumnsNames());
        System.out.println("excelUtil.getDataList() = " + excelUtil.getDataList());
        for (Map<String, String> stringStringMap : excelUtil.getDataList()) {
            System.out.println(stringStringMap);
        }

        //count starts from not first row which includes headers but two.
        List<Map<String, String>> dataList = excelUtil.getDataList();
        System.out.println(dataList.get(2).get("firstname"));

        //get all data in 2d array
        String[][] dataArray = excelUtil.getDataArray();
        for (String[] strings : dataArray) {
            for (String string : strings) {
                System.out.println(string);
            }
        }
        System.out.println(Arrays.deepToString(dataArray));

        for (String[] strings : dataArray) {
            System.out.println(Arrays.toString(strings));
        }
    }


}
