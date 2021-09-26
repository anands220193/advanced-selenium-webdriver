package checkboxespagetests;

import Pages.CheckBoxesPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test

    public void selectingTwoCheckboxesTest(){

        log.info("Staring selectingTwoCheckboxes");

        //open main page
        WelcomePage welcomePage=new WelcomePage(driver,log);
        welcomePage.openPage();

        //Click on Checkboxes link
        CheckBoxesPage checkBoxesPage=welcomePage.clickCheckboxesLink();

        //Select All Checkboxes
        checkBoxesPage.selectAllCheckboxes();

        //Verify all Checkboxes are checked
        Assert.assertTrue(checkBoxesPage.areAllCheckboxesChecked(), "Not all boxes are checked");

    }

}
