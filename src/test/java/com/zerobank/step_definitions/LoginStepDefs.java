package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public static void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        MainPage mainPage=new MainPage();
        mainPage.signinButton.click();

    }

    @When("the user enters valid credential")
    public static void the_user_enters_valid_credential() {
        LoginPage loginPage=new LoginPage();
        loginPage.usernameTextbox.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordTextbox.sendKeys(ConfigurationReader.get("password"));
        loginPage.submitButton.click();
    }



    @When("the user enters invalid username")
    public void the_user_enters_invalid_username() {
        LoginPage loginPage=new LoginPage();
        loginPage.usernameTextbox.sendKeys("anyusername");
        loginPage.passwordTextbox.sendKeys(ConfigurationReader.get("password"));
        loginPage.submitButton.click();

    }
    @Then("the user should see the {string} message")
    public void the_user_should_see_the_message(String expectedErrorMessage) {
        LoginPage loginPage=new LoginPage();
        String actualErrorMessage = loginPage.invalidUserMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    @When("the user enters invalid password")
    public void the_user_enters_invalid_password() {
        LoginPage loginPage= new LoginPage();
        loginPage.usernameTextbox.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordTextbox.sendKeys("anypassword");
        loginPage.submitButton.click();
    }

    @When("the user enters invalid username and password")
    public void the_user_enters_invalid_username_and_password() {
        LoginPage loginPage= new LoginPage();
        loginPage.usernameTextbox.sendKeys("anyusername");
        loginPage.passwordTextbox.sendKeys("anypassword");
        loginPage.submitButton.click();
    }

    @When("the user leaves the username and password blank")
    public void the_user_leaves_the_username_and_password_blank() {
        LoginPage loginPage=new LoginPage();
        loginPage.submitButton.click();
    }



}
