package com.epam.gittesting.factory;

import com.epam.gittesting.data.NewRepoData;
import com.epam.gittesting.entity.*;
import com.epam.gittesting.pageobject.DeleteRepoPage;
import com.epam.gittesting.pageobject.LoginPage;
import com.epam.gittesting.pageobject.NewRepoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NewRepoTest {

    private WebDriver driver;
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
        NewRepoPage repoPage = new NewRepoPage(driver);
        repoPage.createRepo(repoData.getRepoName());
        System.out.println();
        DeleteRepoPage deleteRepo = new DeleteRepoPage(driver, properties, repoData.getRepoName());
        deleteRepo.delete();
    }

    @AfterClass
    public void closingWindow() {
        WebDriverSingleton.closeDriver();
    }
}