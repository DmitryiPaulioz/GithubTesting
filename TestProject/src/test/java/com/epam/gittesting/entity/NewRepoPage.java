package com.epam.gittesting.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRepoPage {

    private final WebDriver driver;
    private String createdRepoTitle = "";
    private int driverWait = 3;
    private By newRepoName = By.id("repository_name");
    private By accessButton = By.cssSelector("button.btn.btn-primary.first-in-line");


    public NewRepoPage(WebDriver driver, String username) {
        this.driver = driver;
        createdRepoTitle = username;
    }

    private void typeRepoName(String name) {
        createdRepoTitle += "/" + name;
        driver.findElement(newRepoName).sendKeys(name);
    }

    private void submitProfile() {
        driver.findElement(accessButton).click();
        (new WebDriverWait(driver, driverWait)).until(ExpectedConditions.titleIs(createdRepoTitle));
    }

    public void createRepo(String name) {
        typeRepoName(name);
        submitProfile();
    }
}
