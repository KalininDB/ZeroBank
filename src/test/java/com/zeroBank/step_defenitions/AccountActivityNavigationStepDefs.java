package com.zeroBank.step_defenitions;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AccountActivityNavigationStepDefs {

    @When("the user clicks on {string} link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed(String string) {
        Driver.get().findElement(By.linkText(string)).click();
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertTrue(accountActivityPage.AccountActivitySelected.isDisplayed());

    }

}