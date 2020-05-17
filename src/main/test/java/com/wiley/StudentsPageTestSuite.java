package com.wiley;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StudentsPageTestSuite {
    private WebDriver driver;
    private StudentsPage studentsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wiley.com/en-us/students");
        studentsPage = new StudentsPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
