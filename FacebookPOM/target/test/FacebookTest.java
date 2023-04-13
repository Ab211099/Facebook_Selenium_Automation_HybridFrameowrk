package com.bridelabz.selenium.test;

import com.beust.jcommander.Parameter;
import com.bridgelabz.selenium.base.Baseclass;
import com.bridgelabz.selenium.dataprovider.DataProviderLogic;
import com.bridgelabz.selenium.pages.CreateNewPost;
import com.bridgelabz.selenium.pages.Dashboard;
import com.bridgelabz.selenium.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class FacebookTest extends Baseclass {

    LoginPage loginPage;
    Dashboard dashboard;
    CreateNewPost createNewPost;
    @BeforeMethod
    @Parameters("browserName")
    public void setup(@Optional("chrome") String browser) {

        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        createNewPost = new CreateNewPost(driver);
    }

    @Test(priority = 0)
    public void validateUrlNavigation() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.facebook.com/", currentUrl);
    }

    @Test( priority = 1, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
//    @Parameters({"userName","userPassword"})
    public void loginToFacebook(String userName, String userPassword) throws InterruptedException {
        String loginPageTitle = loginPage.loginToFacebook(userName,userPassword );
        if(loginPageTitle == "Facebook"){
            Assert.assertEquals("Facebook",loginPageTitle);
        } else if (loginPageTitle == "(1) Facebook") {
            Assert.assertEquals("(1) Facebook",loginPageTitle);
        }

    }

    @Test( priority = 2, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void dashboardValidation_Success(String userName , String userPassword) throws InterruptedException {
        loginPage.loginToFacebook(userName,userPassword);
        Thread.sleep(500);
        Boolean flag = dashboard.homeTestValidation();
        Assert.assertEquals(true,flag);
    }

    @Test( priority = 3, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void dashboardValidation_Success1(String userName) throws InterruptedException {
        loginPage.loginToFacebook1(userName);
        Thread.sleep(500);
    }

    @Test( priority = 4 , dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void fileUpload_Success(String useName, String userPassword ) throws InterruptedException, IOException {
        loginPage.loginToFacebook(useName,userPassword);
        boolean postID = createNewPost.postAddedImage();
        Assert.assertEquals(true,postID);

    }

    @AfterMethod
    public void browserClose() {
        tearDown();
    }

}
