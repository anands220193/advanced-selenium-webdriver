package hoverstests;

import Pages.HoversPage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {

    @Test

    public void hoversTests(){

        log.info("Starting Hovers Test");

        //Open hovers page
        HoversPage hoversPage=new HoversPage(driver,log);
        hoversPage.openPage();

        //Open User 2 profile
        hoversPage.openUserProfile(2);

        //Verify correct user profile opened
        Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"), "URL of opened page is not expected User1 page URL");
    }

}
