package draganddroptests;

import Pages.DragAndDropPage;
import Pages.UploadPage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {

    @Test

    public void dragAndDropTests(){

        log.info("Staring Drag And Drop Test");

        //Open Drag And Drop Page
        DragAndDropPage dragAndDropPage=new DragAndDropPage(driver,log);
        dragAndDropPage.openPage();

        //Drag box A to box B
        dragAndDropPage.dragAtoB();

        //Verify correct headers in correct boxes
        String columnAText=dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Column A header should be 'B' but it is: "+columnAText);

        //Verify correct headers in correct boxes
        String columnBText=dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"), "Column B header should be 'A' but it is: "+columnBText);


    }
}
