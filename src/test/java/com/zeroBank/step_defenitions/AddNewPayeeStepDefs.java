package com.zeroBank.step_defenitions;

import com.zeroBank.pages.PayMeePage;
import com.zeroBank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddNewPayeeStepDefs {
    PayMeePage payMeePage = new PayMeePage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payMeePage.AddNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> map) {

        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());
        for (String each : list) {

            for (WebElement each1 : payMeePage.TableAddNewPayee) {
                if (each.toLowerCase().contains(each1.getAttribute("name"))) {
                    each1.sendKeys(map.get(each));
                    break;
                }
            }
        }
        payMeePage.ButtonAddNewPayee.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String str) {
        BrowserUtils.waitForVisibility(payMeePage.Message, 3);
        Assert.assertTrue(payMeePage.Message.isDisplayed());
        Assert.assertTrue(payMeePage.Message.getText().equals(str));


    }


}
