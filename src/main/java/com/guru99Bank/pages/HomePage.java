package com.guru99Bank.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleHomePage = By.xpath("//td[contains(text(),'Manger Id : mngr261185')]");
    private By managerIdElement = By.xpath("//td[contains(text(),'Manger Id : mngr261185')]");

    public String getTitleHomePage() {
        return driver.findElement(titleHomePage).getText();
    }

    public String getManagerId() {
        return driver.findElement(managerIdElement).getText();
    }

    public void takeScreenshotHomePage() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Screenshots/FromHomePage/screen.png"));
    }
}
