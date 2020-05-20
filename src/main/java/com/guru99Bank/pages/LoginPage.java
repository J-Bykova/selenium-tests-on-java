package com.guru99Bank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userIdField = By.xpath("//input[@name='uid']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//input[@name='btnLogin']");

    public LoginPage typeUserId(String userId) {
        driver.findElement(userIdField).sendKeys(userId);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomePage loginIn(String userId, String password) {
        this.typeUserId(userId);
        this.typePassword(password);
        driver.findElement(loginButton).submit();
        return new HomePage(driver);
    }

    public LoginPage invalidLoginIn(String userId, String password) {
        this.typeUserId(userId);
        this.typePassword(password);
        driver.findElement(loginButton).submit();
        return new LoginPage(driver);
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
}
