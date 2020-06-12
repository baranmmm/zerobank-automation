package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    @Then("the user should be on Account Summary page")
    public void the_user_should_be_on_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        String actualPageTitle = accountSummaryPage.getPageTitle();
        String expectedPageTitle = "Account Summary";
        Assert.assertEquals(expectedPageTitle,actualPageTitle);

    }

    @Then("the title of the Account Summary page should be {string}")
    public void the_title_of_the_Account_Summary_page_should_be(String expectedTitle) {

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("subMenu options should be as following:")
    public void submenu_options_should_be_as_following(List<String > expectedSubMenuOptions) {

        List<String> actualSubMenuOptions = BrowserUtils.getElementsText(new AccountSummaryPage().subMenuList);

        Assert.assertEquals(expectedSubMenuOptions,actualSubMenuOptions);
    }

    @Then("{string} subMenu table's columns should be as following:")
    public void submenu_table_s_columns_should_be_as_following(String subMenu, List<String > expectedColumnsList) {

        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        List<WebElement> columnNameList = accountSummaryPage.getColumnNameList(subMenu);
        List<String > actualColumnList=new ArrayList<>();
        for (WebElement webElement : columnNameList) {
            actualColumnList.add(webElement.getText());
        }

        Assert.assertEquals(expectedColumnsList,actualColumnList);
    }

    @When("the user navigates to {string} tab")
    public void the_user_navigates_to_tab(String tabName) {
        new AccountSummaryPage().navigateTo(tabName);
    }

}
