package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {

    @Then("the title of the Account Activity page should be {string}")
    public void the_title_of_the_Account_Activity_page_should_be(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the default option of Account dropdown menu should be Savings")
    public void the_default_option_of_Account_dropdown_menu_should_be_Savings() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Select accountDropdown=new Select(accountActivityPage.accountDropdown);
        String actualDefaultOption = accountDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOption= "Savings";
        Assert.assertEquals(expectedDefaultOption,actualDefaultOption);
    }

    @Then("Account dropdown menu options should be as following")
    public void account_dropdown_menu_options_should_be_as_following(List<String> expectedDropdownOptions) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Select accountDropdown=new Select(accountActivityPage.accountDropdown);
        List<WebElement> accountDropdownOptions = accountDropdown.getOptions();
        List<String> actualDropdownOptions = BrowserUtils.getElementsText(accountDropdownOptions);
        Assert.assertEquals(expectedDropdownOptions,actualDropdownOptions);

    }

    @Then("Show Transaction table should contain following columns")
    public void show_Transaction_table_should_contain_following_columns(List<String> expectedTableColumns) {

        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<String> actualTableColumnList = accountActivityPage.getTableColumnList("//table");
        Assert.assertEquals(expectedTableColumns, actualTableColumnList);


    }
}
