package com.wiley;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTestSuite {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wiley.com/en-us");
        mainPage = new MainPage(driver);
    }

    @Test
    public void should_have_WhoWeServe_link_are_displayed_in_the_top_menu() {
        Assert.assertTrue(mainPage.is_whoWeServe_MenuItemPresent());
    }

    @Test
    public void should_have_Subjects_link_are_displayed_in_the_top_menu() {
        Assert.assertTrue(mainPage.is_subjects_MenuItemPresent());
    }

    @Test
    public void should_have_About_link_are_displayed_in_the_top_menu() {
        Assert.assertTrue(mainPage.is_about_MenuItemPresent());
    }

    @Test
    public void WhoWeServe_menu_should_contain_12_items (){
        Assert.assertEquals(12, mainPage.getNumberOfItemsIn_whoWeServe());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
