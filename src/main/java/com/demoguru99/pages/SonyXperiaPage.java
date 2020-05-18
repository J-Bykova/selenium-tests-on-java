package com.demoguru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SonyXperiaPage {
    WebDriver driver;

    public SonyXperiaPage(WebDriver driver) {
        this.driver = driver;
    }
    private By priceSonyXperia = By.xpath("");

    public String getPriceSonyXperia() {
        String priceSonyXperiaText = driver.findElement(priceSonyXperia).getText().toLowerCase();
        return priceSonyXperiaText;
    }
}
