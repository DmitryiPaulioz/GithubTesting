package com.epam.gittesting.factory;

import com.epam.gittesting.data.CommonVariables;
import com.epam.gittesting.data.NewRepoData;
import com.epam.gittesting.entity.LoginPage;
import com.epam.gittesting.entity.NewRepoPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewRepoTest implements CommonVariables {

    private WebDriver driver = null;
    private WebDriverWait wait = null;

    @BeforeTest
    public void beforeTest() {
        System.setProperty(geckodriver, exePath);
        driver = new FirefoxDriver();
        driver.get(profileURL);
    }

    @BeforeMethod
    public void login() {
        wait = new WebDriverWait(driver, 3);
        if (driver.getCurrentUrl().equals(loginPageURL)) {
            LoginPage login = new LoginPage(driver);
            login.loginAs(username, password);
            wait.until(ExpectedConditions.urlToBe(profileURL));
            driver.get(newRepoURL);
            wait.until(ExpectedConditions.urlToBe(newRepoURL));
        }
    }

    @Test
    public void repoTest() throws InterruptedException {
        NewRepoData repoData = new NewRepoData();
        NewRepoPage repoPage = new NewRepoPage(driver, username);
        repoPage.createRepo(repoData.getRepoName());
        Assert.assertTrue(true);
    }

    @AfterTest
    public void closingWindow(){
        driver.quit();
    }
}