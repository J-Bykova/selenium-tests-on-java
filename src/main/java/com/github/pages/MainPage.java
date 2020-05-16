package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//header//a[contains(text(), 'Sign\\u00A0in')]")
    private WebElement singInButton;
    @FindBy(xpath = "")
    private WebElement singUpButton;
    @FindBy(xpath = "")
    private WebElement usernameField;
    @FindBy(xpath = "")
    private WebElement emailField;
    @FindBy(xpath = "")
    private WebElement passwordField;
    @FindBy(xpath = "")
    private WebElement signUpForGitHubButton;

    public LoginPage clickSingInButton() {
        singInButton.click();
        return new LoginPage(driver);
    }

    public SingUpPage clickSingUpButton() {
        singUpButton.click();
        return new SingUpPage(driver);
    }

    public SingUpPage clickSignUpForGitHubButton() {
        signUpForGitHubButton.click();
        return new SingUpPage(driver);
    }

    public MainPage typeUsername(String userName) {
        usernameField.sendKeys(userName);
        return this;
    }

    public MainPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SingUpPage register(String userName, String password, String email) {
        this.typeUsername(userName);
        this.typePassword(password);
        this.typeEmail(email);
        this.clickSignUpForGitHubButton();
        return new SingUpPage(driver);
    }

}
