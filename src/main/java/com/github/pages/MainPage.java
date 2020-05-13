package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singInButton = By.xpath("//header//a[contains(text(), 'Sign\\u00A0in')]");
    private By singUpButton = By.xpath("");
    private By usernameField = By.xpath("//input[@id='user[login]");
    private By emailField = By.xpath("//input[@id='user[email]");
    private By passwordField = By.xpath("//input[@id='user[password]");
    private By signUpForGitHubButton = By.xpath("");

    public LoginPage clickSingInButton() {
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public SingUpPage clickSingUpButton() {
        driver.findElement(singUpButton).click();
        return new SingUpPage(driver);
    }

    public SingUpPage clickSignUpForGitHubButton() {
        driver.findElement(signUpForGitHubButton).click();
        return new SingUpPage(driver);
    }

    public MainPage typeUsername(String userName) {
        driver.findElement(passwordField).sendKeys(userName);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(usernameField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SingUpPage register(String userName, String password, String email) {
        this.typeUsername(userName);
        this.typePassword(password);
        this.typeEmail(email);
        return new SingUpPage(driver);
    }

}
