package com.demoguru99;

import com.demoguru99.pages.SonyXperiaPage;
import com.wiley.StudentsPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SonyXperiaTestSuite {
    private WebDriver driver;
    private SonyXperiaPage sonyXperiaPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/index.php/mobile/sony-xperia.html");
        sonyXperiaPage = new SonyXperiaPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
