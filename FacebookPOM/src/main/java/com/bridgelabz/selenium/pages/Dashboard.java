package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Baseclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends Baseclass {
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement homebtn;


    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean homeTestValidation() {
        Boolean flag = homebtn.isDisplayed();
        return flag;
    }
}
