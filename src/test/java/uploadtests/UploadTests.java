package uploadtests;

import Pages.UploadPage;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTests(int no, String fileName){

        log.info("Staring File upload test #"+no+" for "+fileName);

        //Open upload image page
        UploadPage uploadPage=new UploadPage(driver,log);
        uploadPage.openPage();

        //Select file
        uploadPage.selectFile(fileName);

        //Push upload button
        uploadPage.pushUploadButton();

        //Get uploaded file
        String fileNames=uploadPage.getUploadedFileNames();

        //Verify selected file upload
        Assert.assertTrue(fileNames.contains(fileName),"Our file ("+fileName+") is not uplaoded("+fileNames+")is uploaded");



    }
}
