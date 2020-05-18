package com.demoguru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MobilePage {
    WebDriver driver;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleMobilePage = By.xpath("//h1[contains(text(),'Mobile')]");
    private By sortByDropdownLocator = By.xpath("//*[@class='category-products']/*[@class='toolbar']//*[@class='sort-by']/select");
    private By sortByNameOptionLocator = By.xpath("//*[@class='category-products']/*[@class='toolbar']//*[@class='sort-by']//option[contains(text(), 'Name')]");
    private By sortByPriceOptionLocator = By.xpath("//*[@class='category-products']/*[@class='toolbar']//*[@class='sort-by']//option[contains(text(), 'Price')]");
    private By productNamesLocator = By.xpath("//*[@class='product-name']");
    private By productPriceLocator = By.xpath("//*[@class='price-box']");
    private By priceSonyXperia = By.xpath("");
    private By cardSonyXperia = By.xpath("");

    public SonyXperiaPage clickCardSonyXperia() {
        driver.findElement(cardSonyXperia).click();
        return new SonyXperiaPage(driver);
    }

    public String getPriceSonyXperia() {
        String priceSonyXperiaText = driver.findElement(priceSonyXperia).getText().toLowerCase();
        return priceSonyXperiaText;
    }

    public String getTitleMobilePage() {
        return driver.findElement(titleMobilePage).getText();
    }

    public MobilePage sortByName() {
        driver.findElement(sortByDropdownLocator).click();
        driver.findElement(sortByNameOptionLocator).click();
        return this;
    }

    public void sortByPrice() {
        driver.findElement(sortByDropdownLocator).click();
        driver.findElement(sortByPriceOptionLocator).click();
    }

    public Boolean isSortedByPrice() {
        List<Integer> prices = getProductPrice();

        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i - 1) < prices.get(i)) {
                return false;
            }
        }
        return true;
    }

    public Boolean isSortedByName() {
        List<String> names = getProductNames();

        for (int i = 1; i < names.size(); i++) {
            String curItem = names.get(i).toLowerCase();
            String prevItem = names.get(i - 1).toLowerCase();

            if (prevItem.compareTo(curItem) > 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getProductPrice() {
        List<WebElement> productPriceElements = driver.findElements(productPriceLocator);
        List<Integer> prices = new ArrayList<Integer>();

        for (WebElement productPriceElement : productPriceElements) {
            String price = productPriceElement.getText().substring(1);
            prices.add(Integer.parseInt(price));
        }
        return prices;
    }

    private List<String> getProductNames() {
        List<WebElement> productNameElements = driver.findElements(productNamesLocator);
        List<String> names = new ArrayList<String>();

        for (WebElement productNameElement : productNameElements) {
            names.add(productNameElement.getText());
        }
        return names;
    }


}
