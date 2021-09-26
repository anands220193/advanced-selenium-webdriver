package keypressestests;

import Pages.KeyPressesPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {

    @Test

    public void keyPressesTests(){

        log.info("Starting Key Presses0L,  Value Test");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on KEY PRESSES link
        KeyPressesPage keyPressesPage=welcomePage.clickKeyPressesLink();

        //Push keyboard key
        keyPressesPage.pressKey(Keys.SPACE);

        //Get result text
        String result=keyPressesPage.getResultText();

        //Verification Result text expected
        Assert.assertTrue(result.equals("You entered: SPACE"),"The expected result is text is 'You entered: SPACE'" +
                " and actual result is: " + result);


    }

    @Test

    public void pressKeyWithActionTests(){

        log.info("Starting Press Key With Action Tests");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on KEY PRESSES link
        KeyPressesPage keyPressesPage=welcomePage.clickKeyPressesLink();

        //Push keyboard key
        keyPressesPage.pressKeyWithActionTests(Keys.SPACE);

        //Get result text
        String result=keyPressesPage.getResultText();

        //Verification Result text expected
        Assert.assertTrue(result.equals("You entered: SPACE"),"The expected result is text is 'You entered: SPACE'" +
                " and actual result is: " + result);


    }
}
