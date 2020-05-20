package com.demoguru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleOnHomePageElement = By.xpath("//h2[contains(text(), 'This is demo site for ')]");
    private By mobileLink = By.xpath("//a[contains(text(),'Mobile')]");

    public String getTitleOnHomePage() {
        return driver.findElement(titleOnHomePageElement).getText().toLowerCase().trim();
    }

    public MobilePage clickMobileLink() {
        driver.findElement(mobileLink).click();
        return new MobilePage(driver);
    }


}
