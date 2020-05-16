package com.github.pages;

import com.sun.xml.internal.rngom.digested.DRefPattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingUpPage {
    private WebDriver driver;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerPage = By.xpath("//*[contains(text(), 'Create your account')]");
    private By usernameField = By.xpath("//input[@id='user[login]");
    private By emailField = By.xpath("//input[@id='user[email]");
    private By passwordField = By.xpath("//input[@id='user[password]");
    private By emailPreferencesCheckbox = By.xpath("//input[@id='all_emails']");
    private By createAccountButton = By.xpath("//button[@id='signup_button']");
    private By mainError = By.xpath("//*[contains(text(), 'There were problems creating your account.')]");
    private By userNameError = By.xpath("");
    private By emailError = By.xpath("");
    private By passwordError = By.xpath("");


    public SingUpPage typeUsername(String userName) {
        driver.findElement(usernameField).sendKeys(userName);
        return this;
    }

    public SingUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SingUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public Boolean isButtonEnabled() {
        return driver.findElement(createAccountButton).isEnabled();
    }

    public SingUpPage registerWithInvalidDate(String userName, String email, String password) {
        this.typeUsername(userName);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(createAccountButton).click();
        return new SingUpPage(driver);
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(userNameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }


}
