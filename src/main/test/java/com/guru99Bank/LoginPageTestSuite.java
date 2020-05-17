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
    public void should_open_homePage_when_type_valid_userId_and_password() {
        HomePage newHomePage = loginPage.loginIn(validUserId, validPassword);
        String titleHomePage = newHomePage.getTitleHomePage();
        Assert.assertEquals(expectedTitleHomePage, titleHomePage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
