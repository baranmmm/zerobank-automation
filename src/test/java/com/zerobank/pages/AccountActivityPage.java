package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage extends BasePage {

 public AccountActivityPage(){
     PageFactory.initElements(Driver.get(), this);
 }

@FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

 @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

 @FindBy(id = "aa_toDate")
    public WebElement toDate;

 @FindBy(css = "[type=\"submit\"]")
    public WebElement searchButton;

 @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody//tr//td[1]")
    public List<WebElement> dateList;

 @FindBy(id = "aa_description")
    public WebElement descriptionTextbox;

 @FindBy(xpath = "//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[2]")
    public List<WebElement> descriptionList;

 @FindBy(xpath = "//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[3]")
    public List<WebElement> depositeList;

    @FindBy(xpath = "//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[4]")
    public List<WebElement> withdrawalList;

 @FindBy(id = "aa_type")
    public WebElement typeSelectElement;





}
