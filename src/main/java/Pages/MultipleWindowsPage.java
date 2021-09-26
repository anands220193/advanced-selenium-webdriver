package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject{

    private By multipleWindows=By.xpath("//*[@id=\"content\"]/div/a");

    public MultipleWindowsPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* This method will click on Click here on Opening new window page*/
    public void openWindow(){

        log.info("Clicking Click here on the page");

        click(multipleWindows);

    }

    /* This method will Find page with title 'new window page' and switch*/

    public NewWindowsPage switchToNewWindowsPage(){

        log.info("Looking for 'New window' page");

        switchToWindowWithTitle("New Window");

        return new NewWindowsPage(driver,log);

    }


}
