package org.App.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class RegisterPage {

    public WebDriver driver;
    public  By firstNameInputLocator = By.id("input-firstname");
    public   By lastNameInputLocator = By.id("input-lastname");
    public   By emailInputLocator = By.id("input-email");
    public   By telephoneinputLocator = By.id("input-telephone");
    public   By passwordInputLocator = By.id("input-password");
    public   By confirmPasswordinputLocator = By.id("input-confirm");
    public   By agreetoTermsLocator = By.xpath("//input[@name='agree']");
    public   By continueButtonLocator = By.xpath("//input[contains(@class, 'btn-primary')]");
    public   By alreadyAccountExistAlertLocator = By.xpath("//div[text()=' Warning: E-Mail Address is already registered!']");
    public   By firstName_err_msg_input_locator = By.xpath("//div[contains(text(), 'First Name')]");
    public   By lastName_err_msg_input_locator = By.xpath("//div[contains(text(), 'Last Name')]");
    public   By email_err_msg_input_locator = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
    public  By telephone_err_msg_input_locator = By.xpath("//div[contains(text(), 'Telephone must')]");
    public  By password_err_msg_input_locator = By.xpath("//div[contains(text(), 'Password must')]");
    public  By password_confirm_err_msg_input_locator = By.xpath("//div[contains(text(), 'Password confirm')]");
    public  By privacy_policy_click_alert_input_locator = By.xpath("//div[text()=' Warning: You must agree to the Privacy Policy!']");
public By invalid_registration_check = By.xpath("//div[contains(@class, 'danger')]");

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(firstNameInputLocator);
        boolean checkFirstNameInput = firstNameInput.isEnabled();
        if (checkFirstNameInput) {
            firstNameInput.sendKeys(firstName);
        } else {
            System.out.println("FirstName Input Text Box is Not found on the WebPage ");
        }
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(lastNameInputLocator);
        boolean checkLastNameInput = lastNameInput.isEnabled();
        if (checkLastNameInput) {
            lastNameInput.sendKeys(lastName);
        } else {
            System.out.println("LastName Input Text Box is Not found on the WebPage ");
        }
    }

    public void enterEmail(String email) {
        WebElement inputEmail = driver.findElement(emailInputLocator);
        boolean checkEmailInput = inputEmail.isEnabled();
        if (checkEmailInput) {
            inputEmail.sendKeys(email);
        } else {
            System.out.println("Email Input Text Box is Not found on the WebPage ");
        }

    }

    public void enterTelephoneNumber(String telephone) {
        WebElement inputTelephone = driver.findElement(telephoneinputLocator);
        boolean checkTelephoneInput = inputTelephone.isEnabled();
        if (checkTelephoneInput) {
            inputTelephone.sendKeys(telephone);
        } else {
            System.out.println("Telephone Input Text Box is Not found on the WebPage");
        }
    }

    public void enterPassword(String password) {
        WebElement inputPassword = driver.findElement(passwordInputLocator);
        boolean checkPasswordInput = inputPassword.isEnabled();
        if (checkPasswordInput) {
            inputPassword.sendKeys(password);
        } else {
            System.out.println("Password Input Text Box is Not found on the WebPage");
        }
    }

    public void enterConfirmPassword(String confirm_password) {
        WebElement inputConfirmPassword = driver.findElement(confirmPasswordinputLocator);
        boolean checkConfirmPasswordInput = inputConfirmPassword.isEnabled();
        if (checkConfirmPasswordInput) {
            inputConfirmPassword.sendKeys(confirm_password);
        } else {
            System.out.println("Confirm Password Input Text Box is Not found on the WebPage");
        }
    }

    public void confirmToAgreePrivacyPolicy() {
        WebElement agreeToTerms = driver.findElement(agreetoTermsLocator);
        boolean checkAgreeToTerms = agreeToTerms.isEnabled();
        if (checkAgreeToTerms) {
            agreeToTerms.click();
        } else {
            System.out.println("Privacy policy check box is Not found on the WebPage");
        }
    }

    public void confirmToRegister() throws InterruptedException {
        WebElement confirmToRegister = driver.findElement(continueButtonLocator);
        boolean checkConfirmToRegister = confirmToRegister.isEnabled();
        if(checkConfirmToRegister) {
            confirmToRegister.click();
        }
        else{
            System.out.println("Continue button Not found on the WebPage");
        }
    }

    public boolean checkAccountExistAlert() {
        WebElement accountExistAlertElement = driver.findElement(alreadyAccountExistAlertLocator);
        boolean accountExistAlert = accountExistAlertElement.isEnabled();
        String accountExistAlertText = accountExistAlertElement.getText();
        System.out.println("Account Exist Alert text: " + accountExistAlertText);
        return accountExistAlert;

    }

    public boolean checkFirstName() {
        WebElement firstNameAlertElement = driver.findElement(firstName_err_msg_input_locator);
        boolean firstNameAlert = firstNameAlertElement.isEnabled();
        String firstNameAlertText = firstNameAlertElement.getText();
        System.out.println("Alert text: " + firstNameAlertText);
        return firstNameAlert;
    }

    public boolean checkLastName() {
        WebElement lastNameAlertElement = driver.findElement(lastName_err_msg_input_locator);
        boolean lastNameAlert = lastNameAlertElement.isEnabled();
        String lastNameAlertText = lastNameAlertElement.getText();
        System.out.println("Alert text: " + lastNameAlertText);
        return lastNameAlert;
    }

    public boolean checkEmail() {
        WebElement emailAlertElement = driver.findElement(email_err_msg_input_locator);
        boolean emailAlert = emailAlertElement.isEnabled();
        String emailAlertText = emailAlertElement.getText();
        System.out.println("Alert text: " + emailAlertText);
        return emailAlert;
    }


    public boolean checkTelephone() {
        WebElement telephoneAlertElement = driver.findElement(telephone_err_msg_input_locator);
        boolean telephoneAlert = telephoneAlertElement.isEnabled();
        String telephoneAlertElementText = telephoneAlertElement.getText();
        System.out.println("Alert text: " + telephoneAlertElementText);
        return telephoneAlert;
    }

    public boolean checkPassword() {
        WebElement passwordAlertElement = driver.findElement(password_err_msg_input_locator);
        boolean passwordAlert = passwordAlertElement.isEnabled();
        String passwordAlertText = passwordAlertElement.getText();
        System.out.println("Alert text: " + passwordAlertText);
        return passwordAlert;
    }

    public boolean checkConfirmPassword() {
        WebElement confirmPasswordAlertElement = driver.findElement(password_confirm_err_msg_input_locator);
        boolean passwordAlert = confirmPasswordAlertElement.isEnabled();
        String passwordAlertText = confirmPasswordAlertElement.getText();
        System.out.println("Alert text: " + passwordAlertText);
        return passwordAlert;
    }

    public boolean checkPrivacyPolicy() {
        WebElement privacyPolicyAlertElement = driver.findElement(privacy_policy_click_alert_input_locator);
        boolean privacyPolicyAlert = privacyPolicyAlertElement.isEnabled();
        String passwordAlertText = privacyPolicyAlertElement.getText();
        System.out.println("Alert text: " + passwordAlertText);
        return privacyPolicyAlert;
    }
    public boolean checkinvalidRegistration(){
        WebElement checkinvalidUser = driver.findElement(invalid_registration_check);
        boolean invalidUser = checkinvalidUser.isEnabled();
        String invalidUserAlertText = checkinvalidUser.getText();
        System.out.println(invalidUserAlertText);
        return invalidUser;
    }



}

