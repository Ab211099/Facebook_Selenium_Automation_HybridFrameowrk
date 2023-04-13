package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CreateNewPost extends Baseclass {

    @FindBy(xpath = "//span[contains(text(),'Photo/video')]")
    WebElement photobtn;

    @FindBy(xpath = "//span[contains(text(),'Add photos/videos')]")
    WebElement addPhotosBtn;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")
    WebElement postBtn;


    public CreateNewPost(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean postAddedImage() throws InterruptedException, IOException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        photobtn.click();
        addPhotosBtn.click();
        Thread.sleep(1000);
        Runtime.getRuntime().exec("C:\\Users\\Administrator\\Desktop\\AutoIT\\facebookImgaeUpload.exe");
        Thread.sleep(1000);
        postBtn.click();
        Thread.sleep(2000);
        Boolean flag = postBtn.isDisplayed();
        return flag;


    }

}
