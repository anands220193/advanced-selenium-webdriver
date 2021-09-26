package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class WelcomePage extends BasePageObject{



    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator=By.linkText("Form Authentication");

    private By checkboxesLinkLocator=By.linkText("Checkboxes");

    private By dropdownLinkLocator=By.linkText("Dropdown");

    private By javaScriptAlertsLocator=By.linkText("JavaScript Alerts");

    private By multipleWindowsLocator=By.linkText("Multiple Windows");

    private By editorLinkLocator=By.linkText("WYSIWYG Editor");

    private By keyPressesLinkLocator=By.linkText("Key Presses");

    public WelcomePage(WebDriver driver, Logger log){

        super(driver, log);


    }
    /* Open Welcome Page with its URL*/

    public void openPage(){
        log.info("Opening page: " + pageUrl);

        opeUrl(pageUrl);

        log.info("Page opened");
    }

    /* Open LoginPage by clicking on Form Authentication Link*/

    public LoginPage clickFormAuthenticationLink(){
        log.info("Clicking Form Authentication Link on Welcome Page");

        click(formAuthenticationLinkLocator);

        return new LoginPage(driver, log);
    }

    /* Open CheckboxesPage by Clicking on Checkboxes link*/
    public CheckBoxesPage clickCheckboxesLink(){

        log.info("Clicking on Checkboxes Link on Welcome Page");

        click(checkboxesLinkLocator);

        return new CheckBoxesPage(driver,log);

    }

    /* Open Dropdown by Clicking on Dropdown link*/
    public DropdownPage clickDropdownLink(){

        log.info("Clicking on Dropdown Link on Welcome Page");

        click(dropdownLinkLocator);

        return new DropdownPage(driver,log);

    }

    /* Open JavaScript Alert by Clicking on javaScript Alerts link*/
    public JavaScriptAlertsPage clickJavaScriptAlertsLink(){

        log.info("Clicking on JavaScript Alert Link on Welcome Page");

        click(javaScriptAlertsLocator);

        return new JavaScriptAlertsPage(driver,log);

    }

    /* Open Multiple Window by Clicking on Multiple Window link*/
    public MultipleWindowsPage clickMultipleWindowLink(){

        log.info("Clicking on Multiple WindowPage Link on Welcome Page");

        click(multipleWindowsLocator);

        return new MultipleWindowsPage(driver,log);

    }

    /* Open Multiple Window by Clicking on WYSIWYG Editor link*/
    public EditorPage clickEditorLink(){

        log.info("Clicking on WYSIWYG Editor Link on Welcome Page");

        click(editorLinkLocator);

        return new EditorPage(driver,log);

    }

    /* Open Multiple Window by Clicking on WYSIWYG Editor link*/
    public KeyPressesPage clickKeyPressesLink(){

        log.info("Clicking on Key Presses Link on Welcome Page");

        click(keyPressesLinkLocator);

        return new KeyPressesPage(driver,log);

    }
}
