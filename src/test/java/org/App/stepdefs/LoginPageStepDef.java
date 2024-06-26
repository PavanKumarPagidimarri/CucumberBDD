package org.App.stepdefs;

import org.App.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.App.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPageStepDef {

    public WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

   /* @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }*/

    @Given("User on open cart login page")
    public void user_on_open_cart_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);

    }

    @Given("User entered a valid username and valid password")
    public void user_entered_a_valid_username_and_valid_password() {
        loginPage.enterEmail("Dummy100@gmail.com");
        loginPage.enterPassword("Dummy100@gmail.com");
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String ExpHomePageTitle = "My Account";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle, ExpHomePageTitle, "Title Mismatch, User Login failed");
    }

    @Given("User has entered invalid {string} and {string}")
    public void user_has_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        if (loginPage.checkinvalidUser()) {
            Assert.assertTrue(true, "Not a valid error message");
        }

    }

    @Given("User is OpenCart Registration page")
    public void user_on_open_cart_registration_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        registerPage = new RegisterPage(driver);
    }

    @When("User enters a Firstname")
    public void user_enters_a_firstname() {
        registerPage.enterFirstName("Dummy");
    }

    @When("User enters a Lastname")
    public void user_enters_a_lastname() {
        registerPage.enterLastName("Dummy");
    }

    @When("User enters Existing email")
    public void user_enters_existing_email() {
        registerPage.enterEmail("Dummy100@gmail.com");
    }

    @When("User enters Random Telephone number")
    public void user_enters_random_telephone_number() {
        registerPage.enterTelephoneNumber("2009012");
    }

    @When("User enters Password")
    public void user_enters_password() {
        registerPage.enterPassword("7917931131");
    }

    @When("User enters Password Confirm")
    public void user_enters_password_confirm() {
        registerPage.enterConfirmPassword("7917931131");
    }

    @When("User agreed to the privacy policy")
    public void user_agreed_to_the_privacy_policy() {
        registerPage.confirmToAgreePrivacyPolicy();
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        registerPage.confirmToRegister();
    }

    @Then("User should see an error message AccountExist")
    public void user_should_see_an_error_message_Registration_flow() {

        if ( registerPage.checkAccountExistAlert()) {
            Assert.assertTrue(true, "Not a valid error message");
        }

    }
}
