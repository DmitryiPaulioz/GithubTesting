package com.epam.gittesting.factory;

import com.epam.gittesting.data.CommonVariables;
import com.epam.gittesting.data.ProfileData;
import com.epam.gittesting.entity.LoginPage;
import com.epam.gittesting.entity.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProfileTest implements CommonVariables {

    private WebDriver driver = null;



    @BeforeTest
    public void beforeTest() {
        System.setProperty(geckodriver, exePath);
        driver = new FirefoxDriver();
        driver.get(profileURL);
    }

    @BeforeMethod
    public void login() {
        if (driver.getCurrentUrl().equals(loginPageURL)) {
            LoginPage login = new LoginPage(driver);
            login.loginAs(username, password);
        }
    }

    @Test
    public void AppTest() {
        ProfileData profileData = new ProfileData();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.changeProfileInfo(profileData.getName(), profileData.getBio(), profileData.getBlog(), profileData.getCompany());
        Assert.assertTrue(true);
    }

    @AfterTest
    public void closingWindow(){
        driver.quit();
    }
}
