package jserrortests;

import Pages.JSErrorPage;
import base.TestUtilities;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTests extends TestUtilities {

    @Test

    public void jsErrorTests(){

        log.info("Starting jsError Test");
        SoftAssert softAssert=new SoftAssert();

        //Open Js errror page
        JSErrorPage jsErrorPage=new JSErrorPage(driver,log);
        jsErrorPage.openPage();

        //Get logs
        List<LogEntry> logs= getBrowserLog();

        //Verify there are no JavaScript error in console
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")){
                softAssert.fail("Severe error: "+logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }
}
