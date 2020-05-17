package com.github;

import com.github.pages.SingUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SingUpPageTestSuite {
    private WebDriver driver;
    private SingUpPage singUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        singUpPage = PageFactory.initElements(driver, SingUpPage.class);
    }

    @Test
    public void singUpWithShortPassword() {
        SingUpPage sp = singUpPage.typePassword("qwe");
        String error = sp.getPasswordErrorText();
        Assert.assertEquals("Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter.", error);
    }

    @Test
    public void singUpReservedUserName() {
        String userName = "Jenny";
        SingUpPage page = singUpPage.typeUsername(userName);
        String errorText = page.getUserNameErrorText();
        Assert.assertEquals("Username " + userName + " is not available.", errorText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
