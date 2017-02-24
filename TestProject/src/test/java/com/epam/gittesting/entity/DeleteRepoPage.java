package com.epam.gittesting.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class DeleteRepoPage {

    private final WebDriver driver;
    private String repoName = "";
    private WebElement deleteButton;
    private WebElement deleteConfirmButton;
    private WebElement repoNameField;
    private By successfulDelete = By.className("btn-secondary");
    private String deleteURL;

    public DeleteRepoPage(WebDriver driver, PropertiesHandler properties, String repoName){
        this.driver = driver;
        this.repoName = repoName;
        deleteURL = properties.getData("mainURL") + properties.getData("username") + "/"
                + repoName + "/settings";
        driver.navigate().to(deleteURL);
        deleteButton = driver.findElement(By.xpath("//button[@data-facebox='#delete_repo_confirm']"));
    }

    private void deleteInitialization(){
        deleteButton.click();
    }

    private void typeRepoName(){
        List<WebElement> list = driver.findElements(By.xpath("//input[@name='verify'][@type='text']"));
        repoNameField = list.get(list.size() - 1);
        repoNameField.sendKeys(repoName);
        repoNameField.click();
    }

    private void deleteConfirm(){
        List<WebElement> list = driver.findElements(By.xpath("//button[@type='submit']"));
        deleteConfirmButton = list.get(list.size() - 1);
        deleteConfirmButton.click();
        driver.findElement(successfulDelete);
    }

    public void delete(){
        deleteInitialization();
        typeRepoName();
        deleteConfirm();
    }

}
