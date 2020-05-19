package com.guru99Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userIdField = By.xpath("//input[@name='uid']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//input[@name='btnLogin']");
    private By resetButton = By.xpath("//input[@name='btnReset']");
    private By userIdErrorMessage = By.xpath("//*[contains(text(), 'User-ID must not be blank')]");
    private By passwordErrorMessage = By.xpath("//*[contains(text(), 'Password must not be blank')]");
    private By headerPage = By.xpath("//h2[@class='barone']");

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

    public String getErrorMessage() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
