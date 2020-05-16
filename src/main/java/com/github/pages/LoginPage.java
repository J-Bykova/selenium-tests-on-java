package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameOrEmailAddressField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By singInButton = By.xpath("//input[@name='commit']");
    private By forgotPasswordLink = By.xpath("//a[text()='Forgot password?']");
    private By createAccountLink = By.xpath("//a[text()='Create an account']");
    private By headerPage = By.xpath("//h1[contains(text(),'Sign in to GitHub')]");
    private By errorMessage = By.xpath("");

    public LoginPage typeUserName(String userName) {
        driver.findElement(userNameOrEmailAddressField).sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage incorrectLoginIn(String userName, String password) {
        this.typeUserName(userName);
        this.typePassword(password);
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public String getHeaderText() {
        return driver.findElement(headerPage).getText();
    }

    public String getErrorText() {
        return driver.findElement(errorMessage).getText();
    }

    public SingUpPage createAccount() {
        driver.findElement(createAccountLink).click();
        return new SingUpPage(driver);
    }
    public ResetPasswordPage clickForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return new ResetPasswordPage(driver);
    }
}
