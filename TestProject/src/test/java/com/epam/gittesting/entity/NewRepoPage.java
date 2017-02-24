package com.epam.gittesting.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewRepoPage {

    private final WebDriver driver;
    private By successfulCreating = By.className("primary");
    private WebElement newRepoName;
    private WebElement accessButton;

    public NewRepoPage(WebDriver driver) {
        this.driver = driver;
        newRepoName = driver.findElement(By.id("repository_name"));
        accessButton = driver.findElement(By.cssSelector("button.btn.btn-primary.first-in-line"));
    }

    private void typeRepoName(String name) {
        newRepoName.sendKeys(name);
    }

    private void submitProfile() {
        accessButton.click();
        driver.findElement(successfulCreating);
    }

    public void createRepo(String name) {
        typeRepoName(name);
        submitProfile();
    }

}
