package com.github.pages;

import com.sun.xml.internal.rngom.digested.DRefPattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingUpPage {
    private WebDriver driver;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Create your account')]")
    private WebElement headerPage;

    @FindBy(xpath = "//input[@id='user[login]")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='user[email]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='user[password]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='all_emails']")
    private WebElement emailPreferencesCheckbox;

    @FindBy(xpath = "//button[@id='signup_button']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[contains(text(), 'There were problems creating your account.')]")
    private WebElement mainError;

    @FindBy(xpath = "")
    private WebElement userNameError;

    @FindBy(xpath = "")
    private WebElement emailError;

    @FindBy(xpath = "")
    private WebElement passwordError;


    public SingUpPage typeUsername(String userName) {
        usernameField.sendKeys(userName);
        return this;
    }

    public SingUpPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SingUpPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public Boolean isButtonEnabled() {
        createAccountButton.isEnabled();
        //TODO
        return true;
    }

    public SingUpPage registerWithInvalidDate(String userName, String email, String password) {
        this.typeUsername(userName);
        this.typeEmail(email);
        this.typePassword(password);
        createAccountButton.click();
        return new SingUpPage(driver);
    }

    public String getMainErrorText() {
        return mainError.getText();
    }

    public String getUserNameErrorText() {
        return userNameError.getText();
    }

    public String getEmailErrorText() {
        return emailError.getText();
    }

    public String getPasswordErrorText() {
        return passwordError.getText();
    }


}
