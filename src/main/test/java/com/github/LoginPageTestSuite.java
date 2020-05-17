package com.github;

import com.github.pages.LoginPage;
import com.github.pages.SingUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPageTestSuite {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);

    }

    @Test
    public void loginWithEmptyDate() {
        LoginPage newLoginPage = loginPage.incorrectLoginIn("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectDate() {
        LoginPage newLoginPage = loginPage.incorrectLoginIn("j", "12");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest() {
        SingUpPage singUpPage = loginPage.createAccount();
        String headline = singUpPage.getHeaderText();
        Assert.assertEquals("Create your account", headline);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
