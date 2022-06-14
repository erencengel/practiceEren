package com.cyber.tests.day13_pom;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        String[] str = {"Eren","Alperen","Şerife","Aslıhan"};
        System.out.println("Arrays.stream(str).anyMatch(\"Aslıhan\"::equals) = " + Arrays.stream(str).anyMatch("Şerif"::equals));
    }

}
