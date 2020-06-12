package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        LoginStepDefs.the_user_is_on_the_login_page();
        LoginStepDefs.the_user_enters_valid_credential();
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.clickOnLinkByLinkText("Account Activity");
        new AccountActivityPage().clickOnLinkByLinkText("Find Transactions");
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.fromDate.clear();
        accountActivityPage.fromDate.sendKeys(fromDate);
        accountActivityPage.toDate.clear();
        accountActivityPage.toDate.sendKeys(toDate);
        accountActivityPage.dateList.clear();
    }

    @When("clicks search")
    public void clicks_search() {

        AccountActivityPage accountActivityPage=new AccountActivityPage();

        accountActivityPage.searchButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startingDate, String endingDate) {


        List<LocalDate> checkDates=new ArrayList<>();

        String[] splitStart = startingDate.split("-");
        Integer[] startDate=new Integer[3];

        for (int i=0;i<startDate.length; i++){
            startDate[i]=Integer.parseInt(splitStart[i]);
        }

        LocalDate newStartingLocalDate=LocalDate.of(startDate[0], startDate[1], startDate[2]);

        System.out.println("StartDate"+newStartingLocalDate.toString());


        String[] splitEnd = endingDate.split("-");
        Integer[] endDate=new Integer[3];

        for (int i=0;i<endDate.length; i++){
            endDate[i]=Integer.parseInt(splitEnd[i]);
        }

        LocalDate newEndingLocalDate=LocalDate.of(endDate[0],endDate[1],endDate[2]);

        System.out.println("EndDate"+newEndingLocalDate.toString());

        List<String > dateListString=new ArrayList<>();

        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<WebElement> dateElementList = accountActivityPage.dateList;
        for (WebElement webElement : dateElementList) {
            dateListString.add(webElement.getText());
        }
        System.out.println("dateListString="+dateListString.toString());


        for (String date : dateListString) {
            String[] splittedDate = date.split("-");
            Integer[] checkDate=new Integer[3];
            for (int i = 0; i <splittedDate.length ; i++) {

                checkDate[i]=Integer.parseInt(splittedDate[i]);
            }

            LocalDate newCheckDate=LocalDate.of(checkDate[0], checkDate[1], checkDate[2]);
            checkDates.add(newCheckDate);

        }
        System.out.println("======================");
        System.out.println("CheckDatesList="+checkDates.toString());

        for (int i = 0; i <checkDates.size() ; i++) {
            Assert.assertTrue(checkDates.get(i).isBefore(newEndingLocalDate)|| checkDates.get(i).isEqual(newEndingLocalDate));
            Assert.assertTrue(checkDates.get(i).isAfter(newStartingLocalDate)|| checkDates.get(i).isEqual(newStartingLocalDate));

        }

        accountActivityPage.clickOnLinkByLinkText("Find Transactions");
        System.out.println("0000000000000000000");
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<String> dateListString = BrowserUtils.getElementsText(accountActivityPage.dateList);

        List<LocalDate> checkDates=new ArrayList<>();

        for (String date : dateListString) {
            String[] splittedDate = date.split("-");
            Integer[] checkDate=new Integer[3];
            for (int i = 0; i <splittedDate.length ; i++) {

                checkDate[i]=Integer.parseInt(splittedDate[i]);
            }

            LocalDate newCheckDate=LocalDate.of(checkDate[0], checkDate[1], checkDate[2]);
            checkDates.add(newCheckDate);

        }

        for (int i = 0; i <checkDates.size()-1 ; i++) {
            Assert.assertTrue(checkDates.get(i).isAfter(checkDates.get(i+1)) || checkDates.get(i).isEqual(checkDates.get(i+1)));
        }


    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String searchText) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        accountActivityPage.descriptionTextbox.clear();
        accountActivityPage.descriptionTextbox.sendKeys(searchText);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String expectedSearchResult) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<WebElement> descriptionList = accountActivityPage.descriptionList;
        List<String> descriptionListText = BrowserUtils.getElementsText(descriptionList);


        for (int i = 0; i <descriptionListText.size() ; i++) {
            Assert.assertTrue(descriptionListText.get(i).contains(expectedSearchResult));
        }
        if(descriptionListText.size()==0){
            Assert.assertTrue("Description search should be case insensitive but IT IS CASE SENSITIVE",descriptionListText.contains(expectedSearchResult));
        }

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String notExpectedResult) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<WebElement> descriptionList = accountActivityPage.descriptionList;
        List<String> descriptionListText = BrowserUtils.getElementsText(descriptionList);


        for (String actualSearchResult : descriptionListText) {
            Assert.assertFalse(actualSearchResult.contains(notExpectedResult));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {

    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<String> depositeListText = BrowserUtils.getElementsText(accountActivityPage.depositeList);


        boolean flag=false;
        for (int j = 0; j <depositeListText.size() ; j++) {
            if(!depositeListText.get(j).isEmpty()&&Double.parseDouble(depositeListText.get(j))!=0){
                flag=true;
                break;
            }


        }
        Assert.assertTrue(flag);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        Select typeSelect=new Select(accountActivityPage.typeSelectElement);
        typeSelect.selectByVisibleText(type);
        accountActivityPage.searchButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<String> withdrawalListText = BrowserUtils.getElementsText(accountActivityPage.withdrawalList);


        boolean flag=false;
        for (int j = 0; j <withdrawalListText.size() ; j++) {
            if(!withdrawalListText.get(j).isEmpty()&&Double.parseDouble(withdrawalListText.get(j))!=0){
                flag=true;
                break;
            }


        }
        Assert.assertTrue(flag);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<String> withdrawalListText = BrowserUtils.getElementsText(accountActivityPage.withdrawalList);


        boolean flag=true;
        for (int j = 0; j <withdrawalListText.size() ; j++) {

            if(!withdrawalListText.get(j).isEmpty()){
                flag=true;
            }
            else if(!withdrawalListText.get(j).isEmpty()&&Double.parseDouble(withdrawalListText.get(j))!=0){
                flag=false;
                break;
            }


        }
        Assert.assertTrue(flag);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        AccountActivityPage accountActivityPage=new AccountActivityPage();
        List<String> depositeListText = BrowserUtils.getElementsText(accountActivityPage.depositeList);


        boolean flag=true;
        for (int j = 0; j <depositeListText.size() ; j++) {

            if(!depositeListText.get(j).isEmpty()){
                flag=true;
            }
            else if(!depositeListText.get(j).isEmpty()&&Double.parseDouble(depositeListText.get(j))!=0){
                flag=false;
                break;
            }


        }
        Assert.assertTrue(flag);
    }


}
