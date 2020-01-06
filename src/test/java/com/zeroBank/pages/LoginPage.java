package com.zeroBank.pages;


import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "signin_button")
    public WebElement SignInLink;

    @FindBy(id = "user_login")
    public WebElement Loginfield;

    @FindBy(id = "user_password")
    public WebElement Passwordfield;

    @FindBy(name = "submit")
    public WebElement SignInButton;

    public void fullLogin (String username, String password){
        Loginfield.sendKeys(username);
        Passwordfield.sendKeys(password);
        SignInButton.click();
    }

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement MessageFailLogin;




}
