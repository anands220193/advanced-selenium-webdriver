package editortests;

import Pages.WelcomePage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.EditorPage;

public class EditorTests extends TestUtilities {

    @Test

    public void editorTests() {

        log.info("Starting Default Editor Value Test");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Scroll to the bottom
        welcomePage.scrollToBottom();

        //Click on WYSIWYG Editor link
        EditorPage editorPage=welcomePage.clickEditorLink();

        //Get default editor text
        String editorText=editorPage.getEditorText();

        log.info(editorText);

        //Verification that new page contains expected test in source
        Assert.assertTrue(editorText.equalsIgnoreCase("Your content goes here."),"Editor default text is not expected.It is: "+
                editorText);



    }
}
