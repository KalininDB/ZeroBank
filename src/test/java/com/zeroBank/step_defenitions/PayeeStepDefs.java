package com.zeroBank.step_defenitions;

import com.zeroBank.pages.PayMeePage;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class PayeeStepDefs {

    @Given("the user fill up all fields for payment")
    public void the_user_fill_up_all_fields_for_payment() {

        PayMeePage payMeePage = new PayMeePage();

        Select select = new Select(payMeePage.listOfPayee);
        select.getFirstSelectedOption().click();
        select = new Select(payMeePage.listOfAccount);
        select.getFirstSelectedOption().click();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
        Date date = new Date();
        String Date = sdf.format(date);
        payMeePage.DataField.sendKeys(Date);
        payMeePage.AmountField.sendKeys("1");
        payMeePage.DescriptionField.sendKeys("description");
        payMeePage.payButton.click();
        for (WebElement each : payMeePage.Fields) {
            Assert.assertFalse(each.getText().isEmpty());
        }


    }

    @Then("Message Should be {string}")
    public void message_Should_be(String string) {
        PayMeePage payMeePage = new PayMeePage();
        Assert.assertEquals(string, payMeePage.SuccesfullyMessage.getText());

    }

    @Given("fill up all fields, exclude {string} field")
    public void fill_up_all_fields_exclude_field(String string) {
        PayMeePage payMeePage = new PayMeePage();
        for (WebElement each : payMeePage.NameOfFields) {
            if (!each.getText().equalsIgnoreCase(string)) ;
            for (int i = 0; i >= payMeePage.NameOfFields.size(); i++) {
                if (each.getText().equalsIgnoreCase("Payee")) {
                    Select selectP = new Select(payMeePage.listOfPayee);
                    selectP.getFirstSelectedOption().click();
                } else if (each.getText().equalsIgnoreCase("Account")) {
                    Select selectA = new Select(payMeePage.listOfAccount);
                    selectA.getFirstSelectedOption().click();
                } else if (each.getText().equalsIgnoreCase("Date")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
                    Date date = new Date();
                    String Date = sdf.format(date);
                    payMeePage.DataField.sendKeys(Date);
                } else if (each.getText().equalsIgnoreCase("Amount")) {
                    payMeePage.AmountField.sendKeys("1");
                } else if (each.getText().equalsIgnoreCase("Description")) {
                    payMeePage.DescriptionField.sendKeys("description");
                }
            }
        }
        payMeePage.payButton.click();

    }

    @Then("Failed Message should be {string}")
    public void failed_Message_should_be(String string) {
        PayMeePage payMeePage = new PayMeePage();
        Assert.assertEquals(payMeePage.DataField.getAttribute("validationMessage"), string);
    }

    @Given("fill up all fields for Data field use alphabetical, Data field must be empty")
    public void fill_up_all_fields_for_Data_field_use_alphabetical() {
        PayMeePage payMeePage = new PayMeePage();

        Select select = new Select(payMeePage.listOfPayee);
        select.getFirstSelectedOption().click();
        select = new Select(payMeePage.listOfAccount);
        select.getFirstSelectedOption().click();
        payMeePage.AmountField.sendKeys("1");
        payMeePage.DescriptionField.sendKeys("description");
        payMeePage.DataField.sendKeys("qwerty");
        System.out.println(payMeePage.DataField.getAttribute("value").isEmpty());
        System.out.println(payMeePage.DataField.getAttribute("value"));
        Assert.assertTrue(payMeePage.DataField.getAttribute("value").isEmpty());



    }

    @Given("fill up all fields for Amount field use alphabetical, Amount field must be empty")
    public void fill_up_all_fields_for_Amount_field_use_alphabetical() {
        PayMeePage payMeePage = new PayMeePage();

        Select select = new Select(payMeePage.listOfPayee);
        select.getFirstSelectedOption().click();
        select = new Select(payMeePage.listOfAccount);
        select.getFirstSelectedOption().click();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-d");
        Date date = new Date();
        String Date = sdf.format(date);
        payMeePage.DescriptionField.sendKeys("description");
        payMeePage.AmountField.sendKeys("qwerty");
        System.out.println(payMeePage.AmountField.getAttribute("value").isEmpty());
        System.out.println(payMeePage.AmountField.getAttribute("value"));
        payMeePage.DataField.sendKeys(Date);
        Assert.assertTrue(payMeePage.AmountField.getAttribute("value").isEmpty());



    }
}
