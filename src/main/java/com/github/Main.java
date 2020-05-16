package com.github;

import com.github.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import com.github.pages.*;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
        driver.get("https://github.com/");
        mainPage.register("Jenny", "12345", "Jenny@gmail.com");
        driver.close();


    }
}
