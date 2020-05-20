package com.demoguru99;

import com.demoguru99.pages.MobilePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.demoguru99.testData.MobilePageTestData.*;

public class MobilePageTestSuite {
    private WebDriver driver;
    private MobilePage mobilePage;


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
    public void should_present_in_home_page_text_Mobile() {
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
