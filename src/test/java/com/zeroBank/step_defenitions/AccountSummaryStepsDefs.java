package com.zeroBank.step_defenitions;


import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryStepsDefs {

    @Then("the title should be {string}")
    public void the_title_should_be(String actualTitle) {
    actualTitle = Driver.get().getTitle();
        System.out.println(actualTitle+"\n"+Driver.get().getTitle());
    Assert.assertEquals(Driver.get().getTitle(),actualTitle);

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
