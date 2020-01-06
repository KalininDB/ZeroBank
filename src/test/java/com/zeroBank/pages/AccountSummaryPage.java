package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath ="//h2[.='Credit Accounts']/following-sibling::div[1]//th")
    public List <WebElement> CreditAccountsListColumns;

    @FindBy(xpath = "//h2[@class='board-header']")
    public List <WebElement> listOFAccounts;

    @FindBy(xpath = "//a[.=\"Savings\"]")
    public WebElement SavingsLink;

    @FindBy(linkText = "Brokerage")
    public WebElement BrokerageLink;




}
