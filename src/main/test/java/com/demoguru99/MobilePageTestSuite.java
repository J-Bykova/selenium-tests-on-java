package com.demoguru99;

import com.demoguru99.pages.MobilePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MobilePageTestSuite {
    private WebDriver driver;
    private MobilePage mobilePage;

    private String expectedTitleMobilePage = "MOBILE";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/mobile.html");
        mobilePage = new MobilePage(driver);
    }

    @Test
    public void checkMobilePageTitle() {
        String inputTitleMobilePage = mobilePage.getTitleMobilePage();
        Assert.assertEquals(expectedTitleMobilePage, inputTitleMobilePage);
    }

    @Test
    public void mobile_list_should_sort_by_name() {
        mobilePage.sortByName();
        Assert.assertTrue(mobilePage.isSortedByName());
    }

    @Test
    public void mobile_list_should_sort_by_price() {
        mobilePage.sortByPrice();
        Assert.assertTrue(mobilePage.isSortedByPrice());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
