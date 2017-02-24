package com.epam.gittesting.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement accessButton;
    private By successfulLogin = By.className("btn-secondary");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginField = driver.findElement(By.id("login_field"));
        passwordField = driver.findElement(By.id("password"));
        accessButton = driver.findElement(By.name("commit"));

    }

    private void typeUsername(String username) {
        loginField.sendKeys(username);
    }

    private void typePassword(String password) {
        passwordField.sendKeys(password);
    }

    private void submitLogin() {
        accessButton.click();
        driver.findElement(successfulLogin); //in case of success wil load main page and wait for next navigation() or get()
    }

    public void loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        submitLogin();
    }

}
