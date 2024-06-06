package org.App.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    public WebDriver driver;
    private By firstNameInputLocator = By.id("input-firstname");
    private By lastNameInputLocator = By.id("input-lastname");
    private By emailInputLocator = By.id("input-email");
    private By telephoneinputLocator = By.id("input-telephone");
    private By passwordInputLocator = By.id("input-password");
    private By confirmPasswordinputLocator = By.id("input-confirm");
    private By agreetoTermsLocator = By.xpath("//input[@name='agree']");
    private By continueButtonLocator = By.xpath("//input[contains(@class, 'btn-primary')]");
    private  By alreadyAccountExistAlertLocator = By.xpath("//div[contains(@class, 'alert')]");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(firstNameInputLocator);
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(lastNameInputLocator);
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement inputEmail = driver.findElement(emailInputLocator);
        inputEmail.sendKeys(email);
    }

    public void enterTelephoneNumber(String telephone) {
        WebElement inputTelephone = driver.findElement(telephoneinputLocator);
        inputTelephone.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        WebElement inputPassword = driver.findElement(passwordInputLocator);
        inputPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confirm_password) {
        WebElement inputConfirmPassword = driver.findElement(confirmPasswordinputLocator);
        inputConfirmPassword.sendKeys(confirm_password);
    }

    public void confirmToAgreePrivacyPolicy() {
        WebElement agreeToTerms = driver.findElement(agreetoTermsLocator);
        agreeToTerms.click();
    }

    public void confirmToRegister() {
        WebElement confirmToRegister = driver.findElement(continueButtonLocator);
        confirmToRegister.click();
    }
    public boolean checkAccountExistAlert(){
        boolean accountExistAlert = driver.findElement(alreadyAccountExistAlertLocator).isEnabled();
        String accountExistAlertText = driver.findElement(alreadyAccountExistAlertLocator).getText();
        System.out.println(accountExistAlertText);
        return accountExistAlert;

    }






}
