package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage extends BasePageObject{

    private String pageUrl="http://the-internet.herokuapp.com/horizontal_slider";

    private By rangeLocator=By.xpath("//*[@id=\"range\"]");

    private By sliderLocator=By.tagName("input");

    public HorizontalSliderPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* Open Hovers with its URL*/

    public void openPage(){
        log.info("Opening page: " + pageUrl);

        opeUrl(pageUrl);

        log.info("Page opened");
    }

    //Moving slider to specified value

    public void setSliderTo(String value){

        log.info("Moving slider to value:"+value);

        //Move slider normal method
        //Find the xoffset using given value
        //int width=find(sliderLocator).getSize().getWidth();
        //double percent=Double.parseDouble(value)/5;
        //int xoffset=(int)(width*percent);

        //Actions action=new Actions(driver);
        //action.dragAndDropBy(find(sliderLocator),xoffset,0).build().perform();

        //Workaround method
        //Calculate number of steps
        int steps=(int) (Double.parseDouble(value)/0.5);

        //Perform step
        pressKey(sliderLocator, Keys.ENTER);

        for (int i=0; i<steps; i++);

        {pressKey(sliderLocator,Keys.ARROW_RIGHT);}

    }

    //Getting slider value
    public String getSliderValue(){

       String trueValue=find(rangeLocator).getText();

       log.info("Getting slider actual value");

       return trueValue;

    }
}
