package com.herokuapp.theinternet.loginpagetests;

import Pages.LoginPage;
import Pages.WelcomePage;
import base.CsvDataProviders;
import base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLogInTests extends TestUtilities {


    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLoginTest(Map<String,String> testData) {

        //Data
        String no=testData.get("no");
        String username=testData.get("username");
        String password=testData.get("password");
        String expectedErrorMessage=testData.get("expectedMessage");
        String description=testData.get("description");

        log.info("Starting negative log in Test 3"+no+" for "+description);

        // open main page
        WelcomePage welcomePage=new WelcomePage(driver,log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage=welcomePage.clickFormAuthenticationLink();

        // Execute negative log in
        loginPage.negativeLogIn(username, password);

        //wait for error message
        loginPage.waitForErrorMessage();
        String message= loginPage.getErrorMessageText();

        // push log in button
        driver.findElement(By.className("radius")).click();

        // Verification
        Assert.assertTrue(message.contains(expectedErrorMessage),
                "Message does not contain expected ErrorMessage");
    }



}
