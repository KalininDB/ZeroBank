package com.zeroBank.step_defenitions;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.utilities.BrowserUtils;

import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTransactionStepsDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    Select select;

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.FindTransactions.click();

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {

        accountActivityPage.FromDateInFindTransaction.clear();
        accountActivityPage.FromDateInFindTransaction.sendKeys(from);

        accountActivityPage.ToDateInFindTransaction.clear();
        accountActivityPage.ToDateInFindTransaction.sendKeys(to);


    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.search.click();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {

        List<Integer> list = new ArrayList<>();

        for (WebElement each : accountActivityPage.CheckFilteredTransactionByDates) {
            BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='filtered_transactions_for_account']//tr/td[1]"), 20);
            list.add(Integer.parseInt(each.getText().replace("-", "")));
        }

        Integer toI = Integer.parseInt(to.replace("-", ""));
        Integer fromI = Integer.parseInt(from.replace("-", ""));
        Collections.sort(list);

        System.out.println(list);
        Assert.assertTrue(list.get(list.size() - 1) <= toI);
        Assert.assertTrue(list.get(0) >= fromI);


    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<Integer> list = new ArrayList<>();
        for (WebElement each : accountActivityPage.CheckFilteredTransactionByDates) {
            list.add(Integer.parseInt(each.getText().replace("-", "")));
        }
        Collections.sort(list);
        int i = 1;
        for (WebElement each : accountActivityPage.CheckFilteredTransactionByDates) {
            Assert.assertTrue(list.get(list.size() - i).equals(Integer.parseInt(each.getText().replace("-", ""))));
            i++;
        }

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        for (WebElement each : accountActivityPage.CheckFilteredTransactionByDates) {
            Assert.assertFalse(each.getText().contains(date));
        }

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String str) {
        accountActivityPage.DescriptionInFindTransactions.clear();
        accountActivityPage.DescriptionInFindTransactions.sendKeys(str);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(3);
        if (accountActivityPage.CheckFilteredTransactionByDescription.size()!=0)
        {
            for (WebElement each : accountActivityPage.CheckFilteredTransactionByDescription) {
                Assert.assertTrue(each.getText().contains(string));

            }
        }  else {
            Assert.assertFalse(accountActivityPage.noResults.isDisplayed());
            }






    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        for (WebElement each : accountActivityPage.CheckFilteredTransactionByDescription) {
            Assert.assertFalse(each.getText().contains(string));
        }

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        for (WebElement each : accountActivityPage.CheckFilteredTransactionByDeposit) {
            System.out.println(each.getText());
        }

        //  Assert.assertTrue(accountActivityPage.CheckFilteredTransactionByDeposit.isEmpty());
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertFalse(accountActivityPage.CheckFilteredTransactionByDeposit.isEmpty());

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        System.out.println("Withdraw is empty?" + accountActivityPage.CheckFilteredTransactionByWithdraw.isEmpty());
        for (WebElement each : accountActivityPage.CheckFilteredTransactionByWithdraw) {
            System.out.println(each.getText());
        }


    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        select = new Select(accountActivityPage.Type);
        select.selectByVisibleText(string);
        accountActivityPage.search.click();

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {

        int i = accountActivityPage.CheckFilteredTransactionByWithdraw.size();
        System.out.println(i);
        Assert.assertTrue(i > 0);
        Assert.assertFalse(accountActivityPage.CheckFilteredTransactionByWithdraw.isEmpty());

    }


}
