package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Baseclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Baseclass {


    @FindBy(name = "email")
    WebElement userName;

    @FindBy(name = "pass")
    WebElement userPassword;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String loginToFacebook(String name, String pass) throws InterruptedException {
        userName.sendKeys(name);
        Thread.sleep(500);
        userPassword.sendKeys(pass);
        Thread.sleep(500);
        loginBtn.click();
        Thread.sleep(500);
        String loginTitle = driver.getTitle();
        return loginTitle;
    }

    public void loginToFacebook1(String name) throws InterruptedException {
        userName.sendKeys(name);
        Thread.sleep(500);
    }

}
