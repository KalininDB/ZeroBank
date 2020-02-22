package com.zeroBank.step_defenitions;


import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountSummaryStepsDefs {

    @Then("the title should be {string}")
    public void the_title_should_be(String actualTitle) {
    actualTitle = Driver.get().getTitle();
        System.out.println(actualTitle+"\n"+Driver.get().getTitle());
    Assert.assertEquals(Driver.get().getTitle(),actualTitle);
Actions actions = new Actions(Driver.get());
        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
ArrayList<Cookie> e = new ArrayList<>(Driver.get().manage().getCookies());
Cookie ew = Driver.get().manage().getCookieNamed("sdf");

    }

    @Then("Credit Accounts table must have columns:")
    public void credit_Accounts_table_must_have_columns(List<String> list) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        int i=0;
        for (WebElement each : accountSummaryPage.CreditAccountsListColumns){
            System.out.println("from element: "+each.getText());
            System.out.println("from list: "+list.get(i));
            Assert.assertEquals(each.getText(),list.get(i));
            i++;
        }
        System.out.println("+++++++++++++++++++++++++");
//        WebElement r = Driver.get().findElement(By.xpath("afsdsadfsdf"));
//        WebDriverWait w = new WebDriverWait(Driver.get(), 20);
//        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("afsdsadfsdf")));

    }

    @When("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> list) {
        int i=0;
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        for (WebElement each : accountSummaryPage.listOFAccounts){
            System.out.println("Web element: "+each.getText());
            System.out.println("List: "+list.get(i));
            Assert.assertEquals(each.getText(),list.get(i));
            i++;
        }
    }
}
