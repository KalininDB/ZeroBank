package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
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
        BrowserUtils.waitFor(2);
        File dir = new File(path);
        File[] dir_contents = dir.listFiles();
        long lengthOfFileList = dir_contents.length;
        System.out.println(lengthOfFileList);
        boolean result=false;
        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName) && dir_contents[i].getName().endsWith(ExtName)) {
                System.out.println("Full passed file name: " + dir_contents[i].getName());
                String fileDelte = path+"/"+dir_contents[i].getName();
                result=true;
                System.out.println("result = true");
                try {
                    Files.deleteIfExists(Paths.get(fileDelte));
                    System.out.println("File deleted");
                } catch (Exception e){
                    System.out.println("не сработало!)");
                }
            }
        }
        return result;

    }
}
