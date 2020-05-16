package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO
    @FindBy(xpath = "")
    private WebElement userNameOrEmailAddressField;
    @FindBy(xpath = "")
    private WebElement passwordField;
    @FindBy(xpath = "")
    private WebElement singInButton;
    @FindBy(xpath = "")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "")
    private WebElement createAccountLink;
    @FindBy(xpath = "")
    private WebElement headerPage;
    @FindBy(xpath = "")
    private WebElement errorMessage;


    public LoginPage typeUserName(String userName) {
        userNameOrEmailAddressField.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage incorrectLoginIn(String userName, String password) {
        this.typeUserName(userName);
        this.typePassword(password);
        singInButton.click();
        return new LoginPage(driver);
    }

    public String getHeaderText() {
        return headerPage.getText();
    }

    public String getErrorText() {
        return errorMessage.getText();
    }

    public SingUpPage createAccount() {
        createAccountLink.click();
        return new SingUpPage(driver);
    }

    public ResetPasswordPage clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return new ResetPasswordPage(driver);
    }
}
