package com.wiley;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By whoWeServeButton = By.xpath("//a[contains(text(),'WHO WE SERVE')]");
    private By subjectsButton = By.xpath("//a[contains(text(),'SUBJECTS')]");
    private By aboutButton = By.xpath("//a[contains(text(),'ABOUT')]");
    private By whoWeServeMenuItem = By.xpath("//*[@id='Level1NavNode1']/ul/li[contains(@class, 'dropdown-item')]");

    public Boolean is_whoWeServe_MenuItemPresent() {
        return driver.findElements(whoWeServeButton).size() > 0;
    }

    public Boolean is_subjects_MenuItemPresent() {
        return driver.findElements(subjectsButton).size() > 0;
    }

    public Boolean is_about_MenuItemPresent() {
        return driver.findElements(aboutButton).size() > 0;
    }

    public int getNumberOfItemsIn_whoWeServe() {
        List<WebElement> whoWeServeMenuItems = driver.findElements(whoWeServeMenuItem);
        return whoWeServeMenuItems.size();
    }
}
