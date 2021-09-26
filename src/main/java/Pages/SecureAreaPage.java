package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SecureAreaPage extends BasePageObject  {

    private By logOutButton=By.xpath("//a[@class='button secondary radius']");

    private  String pageUrl="http://the-internet.herokuapp.com/secure";

    private By message=By.id("flash");

    public SecureAreaPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* Get URL Variable from PageObject*/
    public String getPageUrl(){

        return pageUrl;
    }

    /* Verification if logOutButton is visible on the page*/
    public boolean isLogOutButtonVisible(){

        return find(logOutButton).isDisplayed();
    }

    /* Return text from success message*/
    public String getSuccessMessageText(){

        return find(message).getText();
    }
}
