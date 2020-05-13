package com.wiley;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/Users/jenny/Code/IntelliJIDEA/com.github/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
