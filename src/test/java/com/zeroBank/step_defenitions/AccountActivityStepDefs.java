package com.zeroBank.step_defenitions;

import com.zeroBank.pages.AccountActivityPage;
import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.utilities.Driver;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {
    AccountActivityPage accountActivityPage;
    AccountSummaryPage accountSummaryPage;

    @Then("the user click on {string}")
    public void the_user_click_on(String string) {
        Driver.get().findElement(By.xpath("//a[.='" + string + "']")).click();
    }

    @Then("{string} page should have the title {string}")
    public void page_should_have_the_title(String string, String string2) {
        System.out.println(string2);
        System.out.println(Driver.get().getTitle());

        Assert.assertTrue(string2.equalsIgnoreCase(Driver.get().getTitle()));

    }

    @Then("In the Account drop	down default option should be {string}")
    public void in_the_Account_drop_down_default_option_should_be(String string) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select select;
        select = new Select(accountActivityPage.defaultOptionInAccount);
        System.out.println("Actual: "+select.getFirstSelectedOption().getText());
        System.out.println("Excpected: "+string);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),string);
    }

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> list) {
        int i = 0;
        int count = list.size();
        System.out.println(list);
        for (WebElement each : accountActivityPage.listOfAccount){
           if (each.getText().equals(list.get(i))){
               i++;
               count--;
               System.out.println(count);
           }
        }
        System.out.println(count);
        Assert.assertTrue(count==0);

    }


}
