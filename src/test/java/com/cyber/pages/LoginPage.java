package com.cyber.pages;

import com.cyber.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //The annotations that we have used so far coming from testNG. However, @Findby annotations is coming from selenium
    @FindBy(id = "sdfsdff")
    public WebElement username;


}
