package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject{

    private By editor= By.id("tinymce");

    private By frame=By.tagName("iframe");

    public EditorPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* Get text from TinyMce WYSIWYG Editor*/
    public String getEditorText(){

        switchToFrame(frame);

        String text = find(editor).getText();

        log.info("Text from TinyMCE WYSIWYG Editor: " + text);

        return text;
    }


}
