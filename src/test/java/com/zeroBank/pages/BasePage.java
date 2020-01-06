package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;
import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[@class='brand']")
    public WebElement LinkMainPage;

    @FindBy(xpath = "//i[@class='icon-cog']")
    public WebElement SettingDropDown;

    @FindBy(xpath = "//i[@class='icon-cog']")
    public WebElement UserDropDown;

    @FindBy(xpath = "//input[@id='searchTerm']")
    public WebElement SearchInput;

    @FindBy(xpath = "//a[.='Account Activity']")
    public WebElement AccountActivityLink;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li/a")
    public List<WebElement> AccountSummaryMenuList;


}
