package com.wiley;

import org.junit.jupiter.api.DynamicTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/Users/jenny/Code/IntelliJIDEA/com.github/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public class MainPageTestSuite {
        @Test
        public void should_WhoWEServe_link_is_displayed_in_The_top_Menu() {
        }

        @Test
        public void should_Subjects_link_is_displayed_in_the_top_menu() {
        }

        @Test
        public void should_TheWileyNetwork_link_is_displayed_in_the_top_menu() {
        }

        @Test
        public void should_About_link_is_displayed_in_the_top_menu() {
        }

        @Test
        public void should_Contact_link_is_displayed_in_the_top_menu() {
        }

        @Test
        public void should_Help_link_is_displayed_in_the_top_menu() {
        }

        @Test
        public void should_MyAccount_link_is_displayed_in_the_top_menu() {
        }

        @Test
        public void should_be_item_Students_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Instructors_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_BookAuthors_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Professionals_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Researchers_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Institutions_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Librarians_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Corporations_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Societies_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_JournalEditors_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Bookstores_under_WhoWEServe_for_subHeader() {
        }

        @Test
        public void should_be_item_Government_under_WhoWEServe_for_subHeader() {
        }

    }
}
