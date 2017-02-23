package com.epam.gittesting.factory;

import com.epam.gittesting.data.ProfileData;
import com.epam.gittesting.entity.LoginPage;
import com.epam.gittesting.entity.ProfilePage;
import com.epam.gittesting.entity.PropertiesHandler;
import com.epam.gittesting.entity.WebDriverSingleton;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class ProfileTest{

    private WebDriver driver = null;
    private PropertiesHandler properties;
    private String bio = "I don't really know, what to print here, so i'll just put some senseless text. C'mon, it's just a simple test.";
    private String blog = "http//justsomesiteaddress.com";
    private String company = "EPAM Systems";

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
    public void AppTest() {

        login();
        driver.navigate().to(properties.getData("profileURL"));
        ProfileData profileData = new ProfileData();
        //profileData.setName(name);
        //we don't have to set name in case of random generation in getter when we have default meaning of it
        profileData.setBio(bio);
        profileData.setBlog(blog);
        profileData.setCompany(company);
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.changeProfileInfo(profileData.getName(), profileData.getBio(), profileData.getBlog(), profileData.getCompany());
    }

    @AfterTest
    public void closingWindow() {
        //WebDriverSingleton.closeDriver();
    }
}
