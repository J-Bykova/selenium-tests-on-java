package com.wiley;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentsPage {
    private WebDriver driver;

    public StudentsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By studentsHeader = By.xpath("//ul[@class='dropdown-items ps-container ps-theme-default']//a[contains(text(),'Students')]");
    private By url_en_us = By.xpath("");
    private By WileyTextbookRentalLink = By.xpath("//a[contains(text(),'Wiley Textbook Rental')]");


}
