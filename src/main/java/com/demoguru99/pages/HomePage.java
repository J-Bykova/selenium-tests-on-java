package com.demoguru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleHomePage = By.xpath("//h2[contains(text(), 'This is demo site for ')]");
    private By mobileLink = By.xpath("//a[contains(text(),'Mobile')]");

    public String getTitleHomePage() {
        return driver.findElement(titleHomePage).getText();
    }

    public MobilePage clickMobileLink() {
        driver.findElement(mobileLink).submit();
        return new MobilePage(driver);
    }


}
