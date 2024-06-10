package org.App.stepdefs;

import io.cucumber.java.en.And;
import org.App.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.App.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    //User Registration Flow
    //Registration Page Steps Starts here
    @Given("User is on OpenCart Register page")
    public void user_on_open_cart_registration_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        registerPage = new RegisterPage(driver);
    }

    @When("User enters firstname {string}")
    public void user_enters_firstname(String firstName) {
        registerPage.enterFirstName(firstName);
    }

    @When("User enters lastname {string}")
    public void user_enters_lastname(String lastName) {
        registerPage.enterLastName(lastName);
    }

    @When("User enters an email {string}")
    public void user_enters_an_email(String email) {
        registerPage.enterEmail(email);
    }

    @When("User enters number {string}")
    public void user_enters_number(String telephone) {
        registerPage.enterTelephoneNumber(telephone);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        registerPage.enterPassword(password);
    }

    @When("User enters confirm password {string}")
    public void user_enters_confirm_password(String password) {
        registerPage.enterConfirmPassword(password);
    }

    @When("User agreed to the privacy policy")
    public void user_agreed_to_the_privacy_policy() {
        registerPage.confirmToAgreePrivacyPolicy();
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() throws InterruptedException {
        registerPage.confirmToRegister();
    }

    @Then("Check whether account is created or not")
    public void check_registration() {
        String ExpTitle = "Your Account Has Been Created!";
        String title = driver.getTitle();
        try {
            if (registerPage.checkinvalidRegistration()) {
                Assert.assertTrue(true, "Not able to Register");
            }
        } catch (Exception e) {
            if (title.equals("Your Account Has Been Created!")) {
                System.out.println("Account created successfully.");
                Assert.assertEquals(title, ExpTitle, "Not able to perform user registration");
            }

        }
    }
}
