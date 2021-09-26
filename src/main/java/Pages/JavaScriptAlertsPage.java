package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject {

    private By jsAlert = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");

    private By jsConfirm = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");

    private By jsPrompt = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");

    private By resultTextLocator = By.id("result");


    public JavaScriptAlertsPage(WebDriver driver, Logger log) {

        super(driver, log);

    }

    /* This method will click on Js Alert*/
    public void openJsAlert() {

        log.info("Clicking Js Alert on the page");

        click(jsAlert);

    }

    /* This method will click on Js Confirm*/
    public void openJsConfirm() {

        log.info("Clicking Js Confirm on the page");

        click(jsConfirm);

    }

    /* This method will click on Js Prompt*/
    public void openJsPrompt() {

        log.info("Clicking Js Prompt on the page");

        click(jsPrompt);

    }

    public String getAlertText() {

        Alert alert = switchToAlert();

        String alertText = alert.getText();

        log.info("Alert says:" + alertText);

        return alertText;

    }

    public void acceptAlert() {

        log.info("Clicking Ok button on alert");

        Alert alert = switchToAlert();

        alert.accept();
    }

    public void dismissAlert() {

        log.info("Clicking cancel button on alert");

        Alert alert = switchToAlert();

        alert.dismiss();
    }

    public void typeTextIntoAlert(String text) {

        log.info("Type text into alert and pressing ok");

        Alert alert = switchToAlert();

        alert.sendKeys(text);

        alert.accept();
    }

    public String getResultText() {

        String result = find(resultTextLocator).getText();

        log.info("Result text: " + result);

        return result;
    }


}
