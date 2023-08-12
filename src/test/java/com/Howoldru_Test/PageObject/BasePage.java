package com.Howoldru_Test.PageObject;

import com.Howoldru_Test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

        public BasePage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//input[@id='inputName']")
        public WebElement inputName;

        @FindBy(xpath = "//input[@id='inputBirthday']")
        public WebElement inputBirthday;

        @FindBy(xpath = "//button[@id='submitButton']")
        public static WebElement submitButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/h1[2]/span")
    public WebElement estimatedAge;




    }


