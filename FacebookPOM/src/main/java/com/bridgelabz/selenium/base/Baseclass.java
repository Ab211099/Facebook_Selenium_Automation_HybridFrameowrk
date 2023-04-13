package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Baseclass {
    public static WebDriver driver;
    public static Logger log = Logger.getLogger(Baseclass.class.getName());

    public void initialization(String browserName) {

        PropertyConfigurator.configure("C:\\TFP\\FacebookPOM\\log4j.properties");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            log.info("Chrome browser run succeefully");
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.facebook.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }

    public void tearDown() {
        driver.close();
    }
}
