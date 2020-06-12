package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        LoginStepDefs.the_user_is_on_the_login_page();
        LoginStepDefs.the_user_enters_valid_credential();
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.clickOnLinkByLinkText("Pay Bills");
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.clickOnLinkByLinkText("Add New Payee");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String , String> payeeInformation) {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payeeNameTextbox.sendKeys(payeeInformation.get("Payee Name"));
        payBillsPage.payeeAddressTextbox.sendKeys(payeeInformation.get("Payee Address"));
        payBillsPage.payeeAccountTextbox.sendKeys(payeeInformation.get("Account"));
        payBillsPage.payeeDetailsTextbox.sendKeys(payeeInformation.get("Payee details"));
        payBillsPage.addPayeeButton.click();
    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        PayBillsPage payBillsPage=new PayBillsPage();
        String actualMessage = payBillsPage.addPayeeSuccessfulMessage.getText();
        String expectedMessage="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
    }

}
