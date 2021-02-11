package com.AltenPolska.pages;

import com.AltenPolska.utilities.BrowserUtils;
import com.AltenPolska.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//tr[1]//td[4]")
    public WebElement firstCity;

    @FindBy(xpath = "//tr[1]//a")
    public WebElement firstMail;

    @FindBy(xpath = "//tr[1]//td[2]")
    public WebElement firstName;

    @FindBy(xpath = "//tr[1]//td[1]")
    public WebElement firstID;

    @FindBy(xpath="//h3")
    public WebElement pageTitle;

    @FindBy(id = "search-input")
    public WebElement searchButton;

    @FindBy(id = "table-resume")
    public WebElement tableResume;

    @FindBy(xpath = "//tbody")
    public WebElement allTable;

    @FindBy(id = "search-column")
    public WebElement searchColumn;

    @FindBy(id = "match-case")
    public WebElement checkBox;

    @FindBy(id = "clear-button")
    public WebElement clearButton;







    public String getAllBody() {

        return allTable.getText();
    }

    public String tableResume() {

        return tableResume.getText();
    }


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public String getPageSubTitle() {

        return pageTitle.getText();
    }

    public String getUserName(){

        return firstName.getText();
    }

    public String getUserMail(){

        return firstMail.getText();
    }

    public String getUserCity(){

        return firstCity.getText();
    }
    public String getUserID(){

        return firstID.getText();
    }

}