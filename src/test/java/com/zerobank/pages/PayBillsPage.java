package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage extends BasePage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_payee")
    public WebElement payeeDropdownElement;

    @FindBy(id = "sp_account")
    public WebElement accountDropdownElement;

    @FindBy(id = "sp_amount")
    public WebElement amountTextbox;

    @FindBy(id = "sp_date")
    public WebElement dateTextbox;

    @FindBy(id = "sp_description")
    public WebElement descriptionTextbox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//span[.=\"The payment was successfully submitted.\"]")
    public WebElement paymentSuccessfulMessage;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameTextbox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressTextbox;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccountTextbox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsTextbox;

    @FindBy(id = "add_new_payee")
    public WebElement addPayeeButton;

    @FindBy(id = "alert_content")
    public WebElement addPayeeSuccessfulMessage;

    @FindBy(id = "pc_currency")
    public WebElement currencySelectElement;


    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;

    @FindBy(id = "pc_amount")
    public WebElement purchaseAmountTextbox;















}
