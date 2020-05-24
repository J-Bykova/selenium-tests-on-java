package com.guru99Bank;

import com.github.pages.LoginPage;
import com.guru99Bank.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePageTestSuite {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/V4/manager/Managerhomepage.php");
        homePage = PageFactory.initElements(driver, HomePage.class);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
