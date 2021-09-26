package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject{

    private String pageUrl="http://the-internet.herokuapp.com/drag_and_drop";

    private By columnA=By.id("column-a");

    private By columnB=By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* Open Upload with its URL*/

    public void openPage(){
        log.info("Opening page: " + pageUrl);

        opeUrl(pageUrl);

        log.info("Page opened");
    }

    //Perform drag and drop

    public void dragAtoB(){

        log.info("Perform Drag and Drop");

        performDragAndDrop(columnA,columnB);


    }

    //Get text from header

    public String getColumnAText(){

        String header=find(columnA).getText();

        log.info("Column A text:"+header);

        return header;


    }

    //Get text from header

    public String getColumnBText(){

        String header=find(columnB).getText();

        log.info("Column B text:"+header);

        return header;


    }
}
