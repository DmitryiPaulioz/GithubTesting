package com.epam.gittesting.factory;

import com.epam.gittesting.data.NewRepoData;
import com.epam.gittesting.entity.LoginPage;
import com.epam.gittesting.entity.NewRepoPage;
import com.epam.gittesting.entity.PropertiesHandler;
import com.epam.gittesting.entity.WebDriverSingleton;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NewRepoTest {

    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private PropertiesHandler properties;

    private void login() {
        driver.navigate().to(properties.getData("loginURL"));
        LoginPage login = new LoginPage(driver);
        login.loginAs(properties.getData("username"), properties.getData("password"));
    }

    @BeforeClass
    public void initialization() {
        properties = new PropertiesHandler();
        System.setProperty(properties.getEnvironment("geckodriver"), properties.getEnvironment("exePath"));
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    public void repoTest() {
        login();
        driver.navigate().to(properties.getData("newRepoURL"));
        NewRepoData repoData = new NewRepoData();
        NewRepoPage repoPage = new NewRepoPage(driver, properties.getData("username"));
        repoPage.createRepo(repoData.getRepoName());
    }

    @AfterClass
    public void closingWindow() {
        WebDriverSingleton.closeDriver();
    }
}