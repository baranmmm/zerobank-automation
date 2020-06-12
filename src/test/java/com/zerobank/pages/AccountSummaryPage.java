package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(className = "board-header")
    public List<WebElement> subMenuList;

    @FindBy(xpath = "(//table[@class=\"table\"])[1]//tr/th")
    private List<WebElement> CashAccountsColumnList;

    @FindBy(xpath = "(//table[@class=\"table\"])[2]//tr/th")
    private List<WebElement> InvestmentAccountsColumnList;

    @FindBy(xpath = "(//table[@class=\"table\"])[3]//tr/th")
    private List<WebElement> CreditAccountsColumnList;

    @FindBy(xpath = "(//table[@class=\"table\"])[4]//tr/th")
    private List<WebElement> LoanAccountsColumnList;

    @FindBy(linkText = "Savings")
    public WebElement savingsLink;


    public List<WebElement> getColumnNameList(String subMenu){
        if(subMenu.equalsIgnoreCase("Cash Accounts")){
            return CashAccountsColumnList;
        }
        else if(subMenu.equalsIgnoreCase("Investment Accounts")){
            return InvestmentAccountsColumnList;
        }
        else if(subMenu.equalsIgnoreCase("Credit Accounts")){
            return CreditAccountsColumnList;
        }
        else if(subMenu.equalsIgnoreCase("Loan Accounts")){
            return LoanAccountsColumnList;
        }
        else{
            return null;
        }
    }
}
