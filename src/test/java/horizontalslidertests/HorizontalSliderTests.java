package horizontalslidertests;

import Pages.HorizontalSliderPage;
import Pages.HoversPage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {

    @Test

    public void horizontalSliderTests() {

        log.info("Starting Horizontal Slider Tests");

        //Open hovers page
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver, log);
        horizontalSliderPage.openPage();

        String value="1.5";

        //Set slider value
        horizontalSliderPage.setSliderTo(value);

        //Verify slider value
        String sliderValue=horizontalSliderPage.getSliderValue();
        Assert.assertTrue(sliderValue.equals(value), "Range is not correct.It is: "+sliderValue);


    }

}
