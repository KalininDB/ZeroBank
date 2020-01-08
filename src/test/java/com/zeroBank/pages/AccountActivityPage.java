package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AccountActivityPage extends BasePage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//select[@class='input-xlarge']")
    public WebElement defaultOptionInAccount;

    @FindBy(xpath = "//select[@class='input-xlarge']/option")
    public List<WebElement> listOfAccount;

    @FindBy(xpath = "//li[@id='account_activity_tab'][@class='active']")
    public WebElement AccountActivitySelected;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement FindTransactions;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement DescriptionInFindTransactions;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement FromDateInFindTransaction;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement ToDateInFindTransaction;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement search;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> CheckFilteredTransactionByDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> CheckFilteredTransactionByDescription;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody/tr/td[3]")
    public List<WebElement> CheckFilteredTransactionByDeposit;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody/tr/td[4]")
    public List<WebElement> CheckFilteredTransactionByWithdraw;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement Type;

    @FindBy(xpath = "//div[@class=\"well\"]")
    public WebElement noResults;

    @FindBy(id = "aa_accountId")
    public WebElement SelectDropList;



}
