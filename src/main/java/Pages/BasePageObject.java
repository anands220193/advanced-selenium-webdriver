package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log){

        this.driver=driver;
        this.log=log;
    }

    /* Open page with given URL*/
    protected void opeUrl (String url) {
        driver.get(url);
    }

    /* Find element using given locator*/
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /* Find element using given locator*/
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /* Click n element with given locator when its visible*/
    protected void click(By locator) {
        waitForVisibilityOf(locator,5);
        find(locator).click();
    }



    /* Type given text into element with given locator*/
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator,5);
        find(locator).sendKeys(text);
    }

    /* Get URL of current page from browser*/
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /* Get Page title of current page from browser*/
    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    /* Get source of current page from browser*/
    public String getCurrentPageSource(){
        return driver.getPageSource();
    }



    /* Wait for ExpectedConditions for the given amount of time in seconds */

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutSeconds) {

        timeOutSeconds=timeOutSeconds !=null? timeOutSeconds:30;

        WebDriverWait wait=new WebDriverWait(driver, timeOutSeconds);

        wait.until(condition);
    }

    /* Wait for given number of seconds for element with given locator to be visible on the page*/

    protected void waitForVisibilityOf(By locator, int... timeOutSecond) {

        int attempts=0;

        while (attempts<2){
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutSecond.length>0?timeOutSecond[0]:null));

                break;
            }
            catch (StaleElementReferenceException e){

            }
            attempts++;
            }
        }

        /* Wait for alert and then switch to alert*/

    protected Alert switchToAlert(){

        WebDriverWait wait =new WebDriverWait(driver,5);

        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert();
    }

    //Switching to new window

    public void switchToWindowWithTitle(String expectedTitle){

        String firstWindow=driver.getWindowHandle();

        Set<String> allWindows=driver.getWindowHandles();

        Iterator<String> windowsIterator=allWindows.iterator();

        while (windowsIterator.hasNext()){
            String widowHandle=windowsIterator.next().toString();

            if (!widowHandle.equals(firstWindow)){
                driver.switchTo().window(widowHandle);

                if (getCurrentPageTitle().equals(expectedTitle)){
                    break;
                }
            }
        }


    }

    //Switching to iFrame using its Locator

    protected void switchToFrame(By frameLocator){
        driver.switchTo().frame(find(frameLocator));
    }

    //Press key on Locator

    protected void pressKey(By locator,Keys key){
        find(locator).sendKeys(key);
    }

    //Press key using action class

    public void pressKeyWithActionTests(Keys key){

        log.info("Pressing " + key.name() + "using Action Class");

        Actions action=new Actions(driver);

        action.sendKeys(key).build().perform();
    }

    //Perform scroll to the bottom
    public void scrollToBottom(){

        log.info("Scrolling to the bottom of the page");

        JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;

        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //Perform Drag and Drop

    protected void performDragAndDrop(By from,By to){

        // Actions action=new Actions(driver);
        //action.dragAndDrop(find(from),find(to)).build().perform();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);",find(from),find(to));

    }

    //Perform Hover over

    protected void hoverOverElement(WebElement element){

        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();

    }

    //Add cookie
    public void setCookie(Cookie ck){

        log.info("Adding cookie "+ck.getName());

        driver.manage().addCookie(ck);

        log.info("Cookie added");
    }

    //Get cookie value using cookie name
    public String getCookie(String name){

        log.info("Getting cookie name "+name);

        return driver.manage().getCookieNamed(name).getValue();
    }


}

