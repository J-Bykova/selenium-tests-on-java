package com.guru99Bank;

import com.guru99Bank.pages.HomePage;
import com.guru99Bank.pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.guru99Bank.testData.LoginPageTestData.*;
import static com.guru99Bank.testData.HomePageTestData.*;

public class LoginPageTestSuite {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/V4/");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void on_homepage_should_be_manager_id_is_correct(){
        HomePage homePage = loginPage.loginIn(validUserId, validPassword);
        String managerId = homePage.getManagerId();
        Assert.assertEquals(expectedManagerId, managerId);
    }

    @Test
    public void should_log_in_successful_with_valid_data() {
        HomePage newHomePage = loginPage.loginIn(validUserId, validPassword);
        String titleHomePage = newHomePage.getTitleHomePage();
        Assert.assertEquals(expectedTitleHomePage, titleHomePage);
    }

    @Test
    public void should_not_log_in_with_invalid_user_id_and_valid_password() {
        LoginPage page = loginPage.invalidLoginIn(invalidUserId, validPassword);
        String popUpWithErrorMessage = page.getAlertMessage();
        Assert.assertEquals(expectedErrorTextForInvalidLoginIn, popUpWithErrorMessage);
    }

    @Test
    public void should_not_log_in_with_valid_user_id_and_invalid_password() {
        LoginPage page = loginPage.invalidLoginIn(validUserId, invalidPassword);
        String popUpWithErrorMessage = page.getAlertMessage();
        Assert.assertEquals(expectedErrorTextForInvalidLoginIn, popUpWithErrorMessage);
    }

    @Test
    public void should_not_log_in_with_invalid_user_id_and_invalid_password() {
        LoginPage page = loginPage.invalidLoginIn(invalidUserId, invalidPassword);
        String popUpWithErrorMessage = page.getAlertMessage();
        Assert.assertEquals(expectedErrorTextForInvalidLoginIn, popUpWithErrorMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
