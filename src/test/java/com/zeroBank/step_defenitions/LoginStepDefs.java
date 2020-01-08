package com.zeroBank.step_defenitions;

import com.zeroBank.pages.LoginPage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        LoginPage loginPage = new LoginPage();
        loginPage.SignInLink.click();
    }

    @Given("the title should contains {string}")
    public void the_title_should_contains(String string) {
        string = Driver.get().getTitle();
        String expected = "Log in";
        Assert.assertTrue(string.contains(expected));
    }

    @When("the users enters the correct credentials")
    public void the_users_enters_the_correct_credentials() {

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.fullLogin(username, password);
    }

    @Then("the user should be able to log in")
    public void the_user_should_be_able_to_log_in() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
    }

    @And("Login and or password are wrong should be displayed")
    public void Login_and_or_password_are_wrong_should_be_displayed() {
        LoginPage loginPage = new LoginPage();
        String  string = "Login and/or password are wrong.";
        BrowserUtils.waitForVisibility(loginPage.MessageFailLogin, 10);
        String actual = loginPage.MessageFailLogin.getText();
        System.out.println("Text actual" + actual + "\n" + "expected Text " + string);
        Assert.assertTrue(actual.contains(string));
    }

    @Then("Account summary should be displayed")
    public void Account_summary_should_be_displayed() {
        Assert.assertTrue(Driver.get().getTitle().contains("Account Summary"));
    }

    @When("the user enter invalid username and valid password")
    public void the_user_enter_invalid_username_and_valid_password() {
        LoginPage loginPage = new LoginPage();
        String wrongUsername = "wrongusername";
        String password = ConfigurationReader.get("password");
        loginPage.fullLogin(wrongUsername, password);

    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        Assert.assertTrue(Driver.get().getTitle().contains("Log in"));
    }

    @When("the user enter invalid password and valid username")
    public void the_user_enter_invalid_password_and_valid_username() {
        LoginPage loginPage = new LoginPage();
        String Username = ConfigurationReader.get("username");
        String WrongPassword = "WrongPassword";
        loginPage.fullLogin(Username, WrongPassword);
    }

    @When("the user enter valid password and blank username")
    public void the_user_enter_valid_password_and_blank_username() {
        LoginPage loginPage = new LoginPage();
        String password = ConfigurationReader.get("password");
        String emptyUsername = loginPage.Loginfield.getText();
        Assert.assertTrue(emptyUsername.isEmpty());
        loginPage.fullLogin(emptyUsername, password);
    }

    @When("the user enter valid username and blank password")
    public void the_user_enter_valid_username_and_blank_password() {
        LoginPage loginPage = new LoginPage();
        String emptyPassword = loginPage.Passwordfield.getText();
        String username = ConfigurationReader.get("username");
        Assert.assertTrue(emptyPassword.isEmpty());
        loginPage.fullLogin(username, emptyPassword);
    }


}
