package com.zeroBank.pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class OnlineStatementsPage {
    public OnlineStatementsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class='nav nav-pills']/li/a")
    public List<WebElement> ListOfYears;

    @FindBy(xpath = "//div[@class='pull-left']//li[@class='active']/a")
    public WebElement SelectedYear;

    @FindBy(xpath = "//div[@class='tab-pane active']//a")
    public List<WebElement> ListOfStatementsOfSelectedYear;

    public boolean CheckNameAndExtentionOfDownloadedFile(String path, String fileName, String ExtName) {
        File dir = new File(path);
        File[] dir_contents = dir.listFiles();
        long lengthOfFileList = dir_contents.length;
        System.out.println(lengthOfFileList);
        boolean result=false;
        for (int i = 0; i < dir_contents.length; i++) {
            System.out.println("Checking file: " + dir_contents[i].getName() + " | should containe name " + fileName + "| and extention " + ExtName);
            if (dir_contents[i].getName().contains(fileName) && dir_contents[i].getName().endsWith(ExtName)) {
                System.out.println("Full passed file name: " + dir_contents[i].getName());
                result=true;

            }
        }
        return result;

    }
}
