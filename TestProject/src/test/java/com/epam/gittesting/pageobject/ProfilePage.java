package com.epam.gittesting.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private final WebDriver driver;
    private WebElement profileNameField;
    private WebElement profileBioField;
    private WebElement profileBlogField;
    private WebElement profileCompanyField;
    private WebElement profileAccessButton;
    private By successfulMessage = By.linkText("view your profile.");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        profileNameField = driver.findElement(By.id("user_profile_name"));
        profileBioField = driver.findElement(By.id("user_profile_bio"));
        profileBlogField = driver.findElement(By.id("user_profile_blog"));
        profileCompanyField = driver.findElement(By.id("user_profile_company"));
        profileAccessButton = driver.findElement(By.cssSelector("p button.btn"));
    }

    private void typeName(String name) {
        profileNameField.clear();
        profileNameField.sendKeys(name);
    }

    private void typeBio(String bio) {
        profileBioField.clear();
        profileBioField.sendKeys(bio);
    }

    private void typeBlog(String blog) {
        profileBlogField.clear();
        profileBlogField.sendKeys(blog);
    }

    private void typeCompany(String company) {
        profileCompanyField.clear();
        profileCompanyField.sendKeys(company);
    }

    private void submitProfile() {
        profileAccessButton.click();
        driver.findElement(successfulMessage);
    }

    public void changeProfileInfo(String name, String bio, String blog, String company) {
        typeName(name);
        typeBio(bio);
        typeBlog(blog);
        typeCompany(company);
        submitProfile();
    }
}
