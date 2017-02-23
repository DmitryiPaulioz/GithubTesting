package com.epam.gittesting.entity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private final WebDriver driver;
    private int driverWait = 3;
    private By profileNameField = By.id("user_profile_name");
    private By profileBioField = By.id("user_profile_bio");
    private By profileBlogField = By.id("user_profile_blog");
    private By profileCompanyField = By.id("user_profile_company");
    private By profileAccessButton = By.cssSelector("p button.btn");
    private By successfulMessage = By.linkText("view your profile.");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeName(String name) {
        WebElement profileName = driver.findElement(profileNameField);
        profileName.clear();
        profileName.sendKeys(name);
    }

    private void typeBio(String bio) {
        WebElement profileBio = driver.findElement(profileBioField);
        profileBio.clear();
        profileBio.sendKeys(bio);
    }

    private void typeBlog(String blog) {
        WebElement profileBlog = driver.findElement(profileBlogField);
        profileBlog.clear();
        profileBlog.sendKeys(blog);
    }

    private void typeCompany(String company) {
        WebElement profileCompany = driver.findElement(profileCompanyField);
        profileCompany.clear();
        profileCompany.sendKeys(company);
    }

    private void submitProfile() {
        driver.findElement(profileAccessButton).click();
        (new WebDriverWait(driver, driverWait)).until(ExpectedConditions.presenceOfElementLocated(successfulMessage));
    }

    public void changeProfileInfo(String name, String bio, String blog, String company) {
        typeName(name);
        typeBio(bio);
        typeBlog(blog);
        typeCompany(company);
        submitProfile();
    }
}
