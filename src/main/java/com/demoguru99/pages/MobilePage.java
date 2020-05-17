package com.demoguru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobilePage {
    WebDriver driver;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleMobilePage = By.xpath("//h1[contains(text(),'Mobile')]");
    private By sortByDropDownList = By.xpath("");
    private By sortByName = By.xpath("");

    public String getTitleMobilePage() {
        return driver.findElement(titleMobilePage).getText();
    }

    public MobilePage selectSortByName() {
        driver.findElement(sortByDropDownList).click();
        driver.findElement(sortByName).click();
        return this;
    }
}
