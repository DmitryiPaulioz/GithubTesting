package com.epam.gittesting.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By accessButton = By.name("commit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
    }

    private void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void submitLogin() {
        driver.findElement(accessButton).click();
    }

    public void loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        submitLogin();
    }

}
