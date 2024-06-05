package org.App.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    //By Locators
    private  By emailInputLocator = By.name("email");
    private  By passwordlInputLocator = By.name("password");
    private  By loginbuttonLocator = By.xpath("//input[@class='btn btn-primary']");
    private  By warningMesageLocator = By.xpath("//div[text()=' Warning: No match for E-Mail Address and/or Password.']");
    private  By limitExceedlocator= By.xpath("//div[text()= ' Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']");
    private  By invalidUserAlertLocator = By.xpath("//div[contains(@class, 'alert')]");
    //Constructor-- to instantiate webdriver
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    //Page Methods or Actions
    /*public void launchApp(String AppURL){
        this.AppURL=AppURL;
    }*/
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordlInputLocator);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginbuttonLocator);
        loginButton.click();

    }

    public boolean checkWarningAlert(){

        boolean warningAlert = driver.findElement(warningMesageLocator).isDisplayed();
        return warningAlert;
    }

    public boolean limitExceedWarningAlert(){
        boolean limitExceedWarningAlert = driver.findElement(limitExceedlocator).isDisplayed();
        return limitExceedWarningAlert;
    }

    public boolean checkinvalidUser(){
        boolean checkinvalidUser = driver.findElement(invalidUserAlertLocator).isEnabled();
        String invalidUserAlertText = driver.findElement(invalidUserAlertLocator).getText();
        System.out.println(invalidUserAlertText);
        return checkinvalidUser;

    }




}
