package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

public class PayBillsStepDefs {

    @Then("the title of the Pay Bills page should be {string}")
    public void the_title_of_the_Pay_Bills_page_should_be(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user should be able to create a successful pay operation")
    public void the_user_should_be_able_to_create_a_successful_pay_operation() {

        PayBillsPage payBillsPage =new PayBillsPage();
        Select payeeDropdown= new Select(payBillsPage.payeeDropdownElement);
        payeeDropdown.selectByVisibleText("Bank of America");
        Select accountDropdown=new Select(payBillsPage.accountDropdownElement);
        accountDropdown.selectByVisibleText("Credit Card");

        payBillsPage.amountTextbox.sendKeys("100");
        payBillsPage.dateTextbox.sendKeys("2020-06-10");
        payBillsPage.descriptionTextbox.sendKeys("Credit card bill");
        payBillsPage.payButton.click();



    }

    @Then("payment successful message should be appeared")
    public void payment_successful_message_should_be_appeared() {
        PayBillsPage payBillsPage=new PayBillsPage();
        String actualPaymentMessage = payBillsPage.paymentSuccessfulMessage.getText();
        String expectedPaymentMessage= "The payment was successfully submitted.";
        Assert.assertEquals(expectedPaymentMessage, actualPaymentMessage);
    }
    @When("the user leaves the amount empty")
    public void the_user_leaves_the_amount_empty() {
        new PayBillsPage().amountTextbox.sendKeys("");
    }

    @When("the user leaves the date empty")
    public void the_user_leaves_the_date_empty() {
        // Write code here that turns the phrase above into concrete actions
        new PayBillsPage().dateTextbox.sendKeys("");
    }

    @Then("{string} message should be appeared")
    public void message_should_be_appeared(String expectedErrorMessage) {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payButton.click();
        String actualErrorMessage = payBillsPage.amountTextbox.getAttribute("validationMessage");
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @When("the user enters alphabetical characters to Amount field")
    public void the_user_enters_alphabetical_characters_to_Amount_field() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.amountTextbox.sendKeys("alphabetical");
        payBillsPage.dateTextbox.sendKeys("2020-06-10");
    }

    @Then("the user should not be able to make a payment")
    public void the_user_should_not_be_able_to_make_a_payment() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.payButton.click();
        try {
            Assert.assertFalse(payBillsPage.paymentSuccessfulMessage.getText()+" message should not be appeared but it is appeared",payBillsPage.paymentSuccessfulMessage.isDisplayed());
        }
        catch (NoSuchElementException e){
            String actualErrorMessage = payBillsPage.dateTextbox.getAttribute("validationMessage");
            Assert.assertEquals("Please fill out this field.", actualErrorMessage);
        }

    }
    @When("the user enters special characters to Amount field")
    public void the_user_enters_special_characters_to_Amount_field() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.amountTextbox.sendKeys("!@#$%^&*");
        payBillsPage.dateTextbox.sendKeys("2020-06-10");
    }

    @When("the user enters alphabetical characters to Date field")
    public void the_user_enters_alphabetical_characters_to_Date_field() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.amountTextbox.sendKeys("100");
        payBillsPage.dateTextbox.sendKeys("alphabetical");
    }
}
