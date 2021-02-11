package com.AltenPolska.tests.testing;

import com.AltenPolska.pages.Page;
import com.AltenPolska.TestBase;
import com.AltenPolska.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Test_2 extends TestBase {


    Page basePage = new Page() ;




    @Test
    public void TC1(){

        System.out.println("Table resume = " +basePage.tableResume());

        System.out.println( basePage.getAllBody());
    }


    @Test
    public void TC2(){

        List<WebElement> headers= Driver.get().findElements(By.xpath("//tr"));
        //how many columns we have ?
        System.out.println("headers = " + headers);
        //print each column name one by one
        for (WebElement header: headers) {

            System.out.println(header.getText());

        }

    }

    @Test
    public void TC3(){

        //number of rows with header
        List<WebElement> allRowsWithHeader = Driver.get().findElements(By.xpath("//table//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = Driver.get().findElements(By.xpath("//tbody//tr"));
        System.out.println(allRowsWithoutHeader.size());


    }

    @Test
    public void TC4(){
        //print the second row information
        WebElement secondRow = Driver.get().findElement(By.xpath("//tbody//tr[2]"));
        System.out.println(secondRow.getText());

        //get all the rows dynamically
        //1.find the number of rows
        //2.iterate one by one

        List<WebElement> allRows = Driver.get().findElements(By.xpath("//tbody//tr"));
        for (int i = 1; i <=allRows.size() ; i++) {

            WebElement row = Driver.get().findElement(By.xpath("//tbody//tr["+i+"]"));
            System.out.println(row.getText());

        }
    }

    @Test
    public void TC_5(){
        List<WebElement> allCelsInOneRow = Driver.get().findElements(By.xpath("//table"));

        for (WebElement cell : allCelsInOneRow) {
            System.out.println(cell.getText());
        }

    }




}
