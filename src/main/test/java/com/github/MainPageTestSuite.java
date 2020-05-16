package com.github;

import com.github.pages.LoginPage;
import com.github.pages.MainPage;
import com.github.pages.SingUpPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

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
        driver.get("https://github.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);

    }

    @Test
    public void singInTest() {
        LoginPage loginPage = mainPage.clickSingInButton();
        String headline = loginPage.getHeaderText();
        Assert.assertEquals("Sign in to GitHub", headline);
    }

    @Test
    public void registerFailTest() {
        SingUpPage singUpPage = mainPage.register("Jenny", "12345", "jenny@gmail.com");
        String error = singUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void singUpEmptyUserNameTest() {
        SingUpPage singUpPage = mainPage.register("", "12345", "Jenny@gmail.com");
        String error = singUpPage.getUserNameErrorText();
        Assert.assertEquals("Username can't be blank", error);
    }

    @Test
    public void singUpInvalidEmailTest() {
        SingUpPage singUpPage = mainPage.register("Jenny", "12345", "Jennygmail.com");
        String error = singUpPage.getEmailErrorText();
        Assert.assertEquals("Email can't be blank", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
