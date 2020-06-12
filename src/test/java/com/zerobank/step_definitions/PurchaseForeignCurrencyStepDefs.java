package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        LoginStepDefs.the_user_is_on_the_login_page();
        LoginStepDefs.the_user_enters_valid_credential();
        new AccountSummaryPage().clickOnLinkByLinkText("Pay Bills");
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.clickOnLinkByLinkText("Purchase Foreign Currency");
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String > expectedCurrencyList) {
        PayBillsPage payBillsPage=new PayBillsPage();
        Select purchaseCurrency=new Select(payBillsPage.currencySelectElement);
        List<WebElement> options = purchaseCurrency.getOptions();
        List<String> actualCurrencyList=new ArrayList<>();


        for (WebElement option : options) {
            actualCurrencyList.add(option.getText());
        }


        boolean containsAll = actualCurrencyList.containsAll(expectedCurrencyList);

            Assert.assertTrue(containsAll);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage=new PayBillsPage();
        payBillsPage.purchaseAmountTextbox.sendKeys("100");
        payBillsPage.purchaseButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Alert alert= Driver.get().switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
        alert.accept();

        Assert.assertTrue(!alertMessage.isEmpty());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage=new PayBillsPage();
        Select selectCurrency=new Select(payBillsPage.currencySelectElement);
        selectCurrency.selectByVisibleText("Eurozone (euro)");
        payBillsPage.purchaseButton.click();


    }

}
