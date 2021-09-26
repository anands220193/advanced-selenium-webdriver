package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JSErrorPage extends BasePageObject{

    private String pageUrl="http://the-internet.herokuapp.com/javascript_error";

    public JSErrorPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* Open Hovers with its URL*/

    public void openPage(){
        log.info("Opening page: " + pageUrl);

        opeUrl(pageUrl);

        log.info("Page opened");
    }


}
