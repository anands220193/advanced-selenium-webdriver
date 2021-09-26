package dropdownpagetests;


import Pages.DropdownPage;
import Pages.WelcomePage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test

    public void optionTwoTest() {

        log.info("Staring optionTwoTest");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on Dropdown link
        DropdownPage dropdownPage=welcomePage.clickDropdownLink();

        //Select option 2
        dropdownPage.selectOption(2);

        //Verify option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected-" + selectedOption);


    }
}
