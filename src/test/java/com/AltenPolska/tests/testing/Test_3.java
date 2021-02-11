package com.AltenPolska.tests.testing;

import com.AltenPolska.TestBase;
import com.AltenPolska.pages.Page;
import com.AltenPolska.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_3 extends TestBase {


    Page basePage = new Page() ;


    @Test
    public void TC_1(){


        basePage.searchButton.sendKeys("regular information");

        Assert.assertEquals(basePage.allTable.getText(),"", "The application shouldn't provide any information");
    } @Test
    public void TC_2() throws InterruptedException{
        String info = "regular information";


        Thread.sleep(1000);
        basePage.searchButton.sendKeys(info);


        WebElement searchSlogan1 = Driver.get().findElement(By.id("table-resume"));
        WebElement searchSlogan2 = Driver.get().findElement(By.id("search-slogan"));
        //System.out.println("searchSlogan2 = " + searchSlogan2.getText());

        String searchSlogan5 = searchSlogan2.getText().replace("click to clear filters","");
        //System.out.println("searchSlogan2 = " + searchSlogan5);
        //

        String text = "Showing 0 of 3 customers filtered by term \"" + info + "\" in Name column without match case.";
        String expected = searchSlogan1.getText()+" "+searchSlogan5;

        Assert.assertEquals(text,expected);


    } @Test
    public void TC_3() throws InterruptedException {

       Thread.sleep(1000);
        String info = "regular information";

        basePage.searchButton.sendKeys(info);

        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("clear-button")));


        Assert.assertTrue(basePage.clearButton.isEnabled());

        element.click();


    }
}
