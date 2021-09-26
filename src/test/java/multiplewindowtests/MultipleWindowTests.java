package multiplewindowtests;

import Pages.MultipleWindowsPage;
import Pages.NewWindowsPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowTests extends TestUtilities {

    @Test

    public void multipleWindowsTest(){

        log.info("Staring Multiple Windows Test");

        //open main page
        WelcomePage welcomePage=new WelcomePage(driver,log);
        welcomePage.openPage();

        //Click on Multiple Windows link
        MultipleWindowsPage multipleWindowsPage=welcomePage.clickMultipleWindowLink();

        //Click on "Click Here" to open a new window
        multipleWindowsPage.openWindow();

        //Find and switch to new window page
        NewWindowsPage newWindowPage=multipleWindowsPage.switchToNewWindowsPage();

        String pageSource=newWindowPage.getCurrentPageSource();

        //Verifying that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"),"New page source does not contains expected text 'New Window'");

    }
}
