package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        LoginStepDefs.the_user_is_on_the_login_page();
        LoginStepDefs.the_user_enters_valid_credential();
    }


    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedPageTitle) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        String actualPageTitle = accountActivityPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedSelectedOption) {

        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Select dropdown=new Select(accountActivityPage.accountDropdown);
        String actualSelectedOption = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedSelectedOption, actualSelectedOption);

    }


    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkText) {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.clickOnLinkByLinkText(linkText);
    }

}
