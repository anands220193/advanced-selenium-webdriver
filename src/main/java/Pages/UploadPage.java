package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePageObject {

    private String pageUrl="http://the-internet.herokuapp.com/upload";

    private By chooseFileLocator=By.id("file-upload");

    private By uploadLocator=By.id("file-submit");

    private By uploadFileLocator=By.id("uploaded-files");

    public UploadPage(WebDriver driver, Logger log){

        super(driver,log);
    }

    /* Open Upload with its URL*/

    public void openPage(){
        log.info("Opening page: " + pageUrl);

        opeUrl(pageUrl);

        log.info("Page opened");
    }


    //Select files
    public void selectFile(String filename){

        log.info("Selecting '"+ filename+ "'from files folder");

        //Selecting files
        //String filePath="C:\\Users\\Puneet\\IdeaProjects\\advanced-selenium-webdriver\\src\\main\\resources\\logo.jpg";

        String filePath=System.getProperty("user.dir") + "//src//main//resources//files//"+filename;

        type(filePath,chooseFileLocator);

        log.info("File Selected");
    }

    //Push upload button
    public void pushUploadButton() {

        log.info("Click on upload button");

        click(uploadLocator);
    }

        //Get name of the uploaded file

    public String getUploadedFileNames(){

        String names=find(uploadFileLocator).getText();

        log.info("Uploaded file name: "+names);

        return names;
    }




}
