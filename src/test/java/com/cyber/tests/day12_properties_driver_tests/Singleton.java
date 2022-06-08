package com.cyber.tests.day12_properties_driver_tests;

import java.util.Random;

public class Singleton {

    //singleton
    //it means that other classed cannot create object of this class
    private Singleton(){}

    private static String str;

    public static String getInstance(){
        //if str has no value, initialize abd return it
        if(str==null){
            System.out.println("str is null. assigning value it");
            str = "somevalue";
        }else {
            //if it has value then return it
            System.out.println("it has value, just returning it");
        }
        return str;
    }

}
