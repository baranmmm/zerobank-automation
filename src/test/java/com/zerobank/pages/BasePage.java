package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(xpath = "//ul[@class=\"nav nav-tabs\"]//li")
    public List<WebElement> menuOptions;

    @FindBy(className = "brand")
    public WebElement zerobankBrand;

    @FindBy(id = "searchTerm")
    public WebElement searchBox;

    @FindBy(xpath = "(//a[@class=\"dropdown-toggle\"])[1]")
    public WebElement settingsButton;

    @FindBy(xpath = "(//a[@class=\"dropdown-toggle\"])[2]")
    public WebElement usernameButton;

    @FindBy(id = "download_webinspect_link")
    public WebElement btmDownloadWebInspect;

    @FindBy(id = "terms_of_use_link")
    public WebElement btmTermsLink;

    @FindBy(id = "contact_hp_link")
    public WebElement btmContactHpLink;

    @FindBy(id = "privacy_statement_link")
    public WebElement btmPrivacyStateLink;

    @FindBy(className = "active")
    public WebElement activePageTitle;

    @FindBy(id = "logout_link")
    private WebElement logOutButton;



    public String getPageTitle(){
        String pageSubtitle = activePageTitle.getText();
        return pageSubtitle;
    }

    public void logOut(){
        usernameButton.click();
        logOutButton.click();

    }

    public void navigateTo(String tabName){
        String tabLocator="//li[.=\""+tabName+"\"]";
        Driver.get().findElement(By.xpath(tabLocator)).click();

    }

    public List<String> getTableColumnList(String tableLocator){

        String columnLocator=tableLocator+"//thead//th";
        List<WebElement> columnNameList = Driver.get().findElements(By.xpath(columnLocator));
        List<String > tableColumnList=new ArrayList<>();
        for (WebElement webElement : columnNameList) {
            tableColumnList.add(webElement.getText());
        }
        return tableColumnList;
    }

    public void clickOnLinkByLinkText(String linkText){
        Driver.get().findElement(By.linkText(linkText)).click();
    }


}
