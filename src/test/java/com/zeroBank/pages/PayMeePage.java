package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayMeePage {
    public PayMeePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (id = "sp_payee")
    public WebElement listOfPayee;

    @FindBy(id = "sp_account")
    public WebElement listOfAccount;

    @FindBy(id="sp_amount")
    public WebElement AmountField;

    @FindBy(id="sp_description")
    public WebElement DescriptionField;

    @FindBy(id="sp_date")
    public WebElement DataField;

    @FindBy(xpath = "//span[.=\"The payment was successfully submitted.\"]")
    public WebElement SuccesfullyMessage;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@class='control-group']/label")
    public List <WebElement> NameOfFields;

    @FindBy(xpath = "//div[@class='control-group']")
    public List <WebElement> Fields;

    @FindBy(xpath = "//a[.=\"Add New Payee\"]")
    public WebElement AddNewPayee;

    @FindBy(xpath = "//div[@id=\"ui-tabs-2\"]//input")
    public List<WebElement> TableAddNewPayee;

    @FindBy(xpath = "//input[@id=\"add_new_payee\"]")
    public WebElement ButtonAddNewPayee;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement Message;

    @FindBy(xpath ="//select[@id='pc_currency']/option")
    public List<WebElement> ListOfCountries;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement PurchaseForeignCurrency;

    @FindBy(id = "pc_amount")
    public WebElement AmountFieldInPFC;

    @FindBy(id = "pc_inDollars_true")
    public WebElement DollarsRadioBInPFC;

    @FindBy(id ="pc_inDollars_false")
    public WebElement SelectCurrencyRadioBInPFC;

    @FindBy(id = "pc_calculate_costs")
    public WebElement CalculateButton;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement SelectionOfCountries;




}
