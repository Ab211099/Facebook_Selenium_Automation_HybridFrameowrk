package com.bridelabz.selenium;
import com.bridgelabz.selenium.base.Baseclass;
import com.bridgelabz.selenium.dataprovider.DataProviderLogic;
import com.bridgelabz.selenium.pages.CreateNewPost;
import com.bridgelabz.selenium.pages.Dashboard;
import com.bridgelabz.selenium.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class FacebookTest extends Baseclass {
    LoginPage loginPage;
    Dashboard dashboard;
    CreateNewPost uploadPost;
     static Logger log = Logger.getLogger(FacebookTest.class.getName());

    @BeforeMethod
//    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new Dashboard(driver);
        uploadPost = new CreateNewPost(driver);

    }

    @Test(priority = 0)
    public void validationURL_Success() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.facebook.com/", currentUrl);
        log.info("Url validation Successfully");
    }



    @Test(priority = 1, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
//    @Parameters({"userName","password"})
    public void LoginToFacebook( String userName, String password) throws InterruptedException {
        String LoginPageTitle = loginPage.loginToFacebook(userName, password);
        if(LoginPageTitle.equalsIgnoreCase("(4) Facebook")) {
            Assert.assertEquals("(4) Facebook", LoginPageTitle);
        }else {
            Assert.assertEquals("Facebook", LoginPageTitle);
        }

        log.info("log into facebook Successfully");
    }


    @Test(priority = 2, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
//    @Parameters({"userName","@password"})
    public void dashboardValidation( String userName, String password) throws InterruptedException {
        String LoginPageTitle = loginPage.loginToFacebook(userName, password);
        if(LoginPageTitle.equalsIgnoreCase("(4) Facebook")) {
            Assert.assertEquals("(4) Facebook", LoginPageTitle);
        }else {
            Assert.assertEquals("Facebook", LoginPageTitle);
        }
        Boolean flag = dashboard.homeTestValidation();
        Assert.assertEquals(true, flag);
    }


//        @Test(priority = 3, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
//        public void DashboardValidation2(String userName) throws InterruptedException {
//            loginPage.loginToFacebook1(userName);
//            Thread.sleep(1000);
//        }

    @Test(priority = 4, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void PostUpload(String userName, String password) throws InterruptedException, IOException {
        loginPage.loginToFacebook(userName, password);
        boolean postValidation = uploadPost.postAddedImage();
        Assert.assertEquals(true, postValidation);
    }


    @AfterMethod
    public void browserClosed() {
        tearDown();
    }

}
