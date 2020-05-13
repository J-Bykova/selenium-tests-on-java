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
    private By error = By.xpath("//*[contains(text(), 'There were problems creating your account.')]");
    private By errorTextForUsernameField = By.xpath("");


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


}
