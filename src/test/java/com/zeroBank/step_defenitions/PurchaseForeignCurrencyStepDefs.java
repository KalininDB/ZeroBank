package com.zeroBank.step_defenitions;

import com.zeroBank.pages.PayMeePage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {
    PayMeePage payMeePage = new PayMeePage();


    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
       payMeePage.PurchaseForeignCurrency.click();


    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> list) {
      int i=0;
        for (WebElement eachW : payMeePage.ListOfCountries){
            for (String eachS : list) {
                if (eachW.getText().equals(eachS)) {
                    i++;
                }
            }
        }
        Assert.assertEquals(i,list.size()-1);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payMeePage.AmountFieldInPFC.sendKeys("111");
        payMeePage.DollarsRadioBInPFC.click();
        payMeePage.CalculateButton.click();


    }



    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Alert alert = Driver.get().switchTo().alert();
        String actual = alert.getText();
        String expected = "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expected,actual);



    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select select = new Select(payMeePage.SelectionOfCountries);
        select.selectByIndex((int)Math.random()*14);
        payMeePage.SelectCurrencyRadioBInPFC.click();
        payMeePage.CalculateButton.click();

    }




}
