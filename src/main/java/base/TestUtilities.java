package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUtilities extends BaseTest{

    @DataProvider(name="files")

    protected static Object[][] files(){

        return new Object[][]{

                {1,"index.html"},
                {2,"logo.png"},
                {3,"text.txt"}
        };

    }

    protected void takeScreenShot(String fileName){

        File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path= System.getProperty("user.dir")
                +File.separator+"test-output"
                +File.separator+"screenshots"
                +File.separator+getTodaysDate()
                +File.separator+testSuiteName
                +File.separator+testName
                +File.separator+testMethodName
                +File.separator+getSystemTime()
                +" "+fileName+".png";

        try {
            FileUtils.copyFile(scrFile,new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        //Today's date in yyyyMMdd format
    private static String getTodaysDate(){
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }


    //Current Time in HHmmssSSS
    private String getSystemTime(){
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    //To get browser console logs
    protected List<LogEntry> getBrowserLog(){

        LogEntries log = driver.manage().logs().get("browser");

        List<LogEntry> logList=log.getAll();

        return logList;

    }
    }



