package com.zeroBank.step_defenitions;

import com.zeroBank.pages.AccountSummaryPage;
import com.zeroBank.pages.OnlineStatementsPage;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StatementAndDocumentsStepsDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();

    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        accountSummaryPage.StatementsLink.click();
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer year) {
        Driver.get().findElement(By.xpath("//ul[@class='nav nav-pills']/li/a[.='" + year + "']")).click();
    }

    @Given("the user selects the Recent Statements Year {string}")
    public void the_user_selects_the_Recent_Statements_Year(String year) {
        Driver.get().findElement(By.xpath("//ul[@class='nav nav-pills']/li/a[.='" + year + "']")).click();
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statementName) {
        Driver.get().findElement(By.xpath("//div[@class='tab-pane active']//a[.='" + statementName + "']")).click();
        WebElement e = Driver.get().findElement(By.xpath("//div[@class='tab-pane active']//a[.='" + statementName + "']"));
        System.out.println("Clicked statement file: " + e.getText());

    }

    @Then("the downloaded file name should contain {string} And the file type should be {string}")
    public void the_downloaded_file_name_should_contain_And_the_file_type_should_be(String fileName, String extention) {
        String path = System.getProperty("user.home") + "/Downloads";
        Assert.assertTrue(onlineStatementsPage.CheckNameAndExtentionOfDownloadedFile(path, fileName, extention));

    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer count) {

        String year = onlineStatementsPage.SelectedYear.getText();
        List<WebElement> CountResult = Driver.get().findElements(By.xpath
                ("//div[@id='os_" + year + "']//tbody/tr/td/a"));
        Integer sizeOfElement = CountResult.size();
        Assert.assertEquals(sizeOfElement, count);
        System.out.println(sizeOfElement + "\n" + count);


    }


}
