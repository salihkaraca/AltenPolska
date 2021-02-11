package com.AltenPolska.tests.testing;

import com.AltenPolska.pages.Page;
import com.AltenPolska.utilities.Driver;
import com.AltenPolska.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test_1 extends TestBase {

    Page basePage = new Page() ;




    @Test
    public void test_1(){


        Assert.assertTrue(basePage.firstID.isDisplayed());

        Assert.assertEquals(basePage.firstID.getText(),  "1","First row must be 1");

    }
    @Test
    public void test_2(){


        Assert.assertTrue(basePage.pageTitle.isDisplayed());

        Assert.assertEquals(basePage.pageTitle.getText(),  "Customers","Checking the title");

    }

    @Test
    public void test_3(){

        Assert.assertTrue(basePage.tableResume.isDisplayed());

        Assert.assertEquals(basePage.tableResume.getText(),  "Showing 3 of 3 customers","Page should include table result");

    }

    @Test
    public void test_4(){

        basePage.searchButton.sendKeys("Alabaster");

        Assert.assertTrue(basePage.tableResume.isDisplayed());

        Assert.assertEquals(basePage.firstName.getText(),  "Alabaster","Checking the result if it is matching with expected.");

    }

    @Test
    public void test_5(){

        Assert.assertTrue( basePage.checkBox.isSelected(), "Checking the checkbox if it is clicked");
        Assert.assertTrue( basePage.checkBox.isEnabled(), "Checking the checkbox if it is enable");

    }

    @Test
    public void test_6(){

        WebElement dropdownElement = basePage.searchColumn;

        basePage.searchColumn.click();

        List<WebElement> options = Driver.get().findElements(By.id("search-column"));


        for (WebElement option: options) {

            System.out.println("option = " + option.getText());

            //Checking Dropdown elements is as expected
            Assert.assertTrue(option.getText().contains("Email"));
            Assert.assertTrue(option.getText().contains("City"));
            Assert.assertTrue(option.getText().contains("Name"));
            Assert.assertTrue(option.getText().contains("Id"));

        }

    }

    @Test
    public void test_7(){

        basePage.searchButton.sendKeys("Postimex");

        // Checking the data after sending specific request
        Assert.assertNotEquals(basePage.firstID,"Alabaster");

    }
}
