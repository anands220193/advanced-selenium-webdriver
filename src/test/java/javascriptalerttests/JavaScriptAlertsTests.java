package javascriptalerttests;

import Pages.JavaScriptAlertsPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTests extends TestUtilities {

    @Test

    public void jsAlertTest(){

        log.info("Staring Js Alert Test");

        SoftAssert softAssert=new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage =welcomePage.clickJavaScriptAlertsLink();

        //Click on Js Alert button
        alertsPage.openJsAlert();

        //Get alert text
        String alertMessage=alertsPage.getAlertText();

        //Click Ok button
        alertsPage.acceptAlert();

        //Get Result text
        String result=alertsPage.getResultText();

        //Verifications
        //1.Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"));

        //2.Result text is expected
        softAssert.assertTrue(result.equals("You successfully clicked an alert"),
                "result is not expected. \nShould be 'You successfully clicked an alert' but the result is"+
                        "'"+result+"'");

        softAssert.assertAll();

    }

    @Test

    public void jsConfirmDismissTest(){

        log.info("Staring Js Confirm Dismiss Test");

        SoftAssert softAssert=new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage =welcomePage.clickJavaScriptAlertsLink();

        //Click on Js Alert button
        alertsPage.openJsConfirm();

        //Get alert text
        String alertMessage=alertsPage.getAlertText();

        //Click Ok button
        alertsPage.dismissAlert();

        //Get Result text
        String result=alertsPage.getResultText();

        //Verifications
        //1.Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"));

        //2.Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You successfully clicked an alert' but the result is"+
                        "'"+result+"'");

        softAssert.assertAll();

    }

    @Test

    public void jsConfirmAcceptTest(){

        log.info("Staring Js Confirm Accept Test");

        SoftAssert softAssert=new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage =welcomePage.clickJavaScriptAlertsLink();

        //Click on Js Alert button
        alertsPage.openJsConfirm();

        //Get alert text
        String alertMessage=alertsPage.getAlertText();

        //Click Ok button
        alertsPage.acceptAlert();

        //Get Result text
        String result=alertsPage.getResultText();

        //Verifications
        //1.Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"));

        //2.Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Ok"),
                "result is not expected. \nShould be 'You successfully clicked an alert' but the result is"+
                        "'"+result+"'");

        softAssert.assertAll();

    }

    @Test

    public void jsPromptTest(){

        log.info("Staring Js Prompt Test");

        SoftAssert softAssert=new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage =welcomePage.clickJavaScriptAlertsLink();

        //Click on Js Alert button
        alertsPage.openJsPrompt();

        //Get alert text
        String alertMessage=alertsPage.getAlertText();

        //Enter String text into alert
        alertsPage.typeTextIntoAlert("Hello Alert,it's me Anand");

        //Get Result text
        String result=alertsPage.getResultText();

        //Verifications
        //1.Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"));

        //2.Result text is expected
        softAssert.assertTrue(result.equals("You entered: Hello Alert,it's me Anand"),
                "result is not expected. \nShould be 'You successfully clicked an alert' but the result is"+
                        "'"+result+"'");

        softAssert.assertAll();

    }
}
