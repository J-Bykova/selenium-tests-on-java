package com.demoguru99;

import com.demoguru99.pages.HomePage;

import static com.demoguru99.testData.HomePageTestData.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

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
    public void should_present_in_home_page_test_ThisIsDemoSite() {
        String titleOnHomePage = homePage.getTitleOnHomePage();
        Assert.assertEquals(expectedTitleHomePage, titleOnHomePage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
