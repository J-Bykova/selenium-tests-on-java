package com.wiley;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderElement {
    private WebDriver driver;

    public HeaderElement(WebDriver driver) {
        this.driver = driver;
    }

    private By logo = By.xpath("");
    private By whoWeServeButton = By.xpath("//a[contains(text(),'WHO WE SERVE')]");
    private By subjectsButton = By.xpath("//a[contains(text(),'SUBJECTS')]");
    private By theWileyNetworkButton = By.xpath("//a[contains(text(),'THE WILEY NETWORK')]");
    private By aboutButton = By.xpath("//a[contains(text(),'ABOUT')]");
    private By countrySelectedButton = By.xpath("//span[@class='country-selected trigger-country-dropdown']");
    private By siteSearchField = By.xpath("//input[@id='js-site-search-input']");

    public void hoverToButton(By xpath) {
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) xpath).build().perform();
    }

    public void clickToButton(By xpath) {
        driver.findElement(xpath).click();
    }

    public void elementIsDisplayed(By xpath) {
        driver.findElement(xpath).isDisplayed();
    }

}
