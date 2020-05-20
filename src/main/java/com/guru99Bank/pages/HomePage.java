package com.guru99Bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleHomePage = By.xpath("//td[contains(text(),'Manger Id : mngr261185')]");

    public String getTitleHomePage() {
        return driver.findElement(titleHomePage).getText();
    }
}
