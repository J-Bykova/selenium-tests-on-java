package com.demoguru99;


import com.demoguru99.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.guru99Bank.testData.HomePageTestData.*;

public class HomePageTestSuite {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/");
        homePage = new HomePage(driver);
    }

    @Test
    public void CheckHomePageTitle() {
        String inputTitleHomePage = homePage.getTitleHomePage();
        Assert.assertEquals(expectedTitleHomePage, inputTitleHomePage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
