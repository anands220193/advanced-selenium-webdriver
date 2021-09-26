package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProviders {

    @DataProvider(name="csvReader")

    public static Iterator<Object[]> csvReader(Method method){

        List<Object[]> list=new ArrayList<Object[]>();

        String pathname="src"+ File.separator+"test"+ File.separator+"resources"+ File.separator+"dataproviders"
                + File.separator+method.getDeclaringClass().getSimpleName()+ File.separator+method.getName()+".csv";

        File file=new File(pathname);

        try{
            CSVReader reader=new CSVReader(new FileReader(file));

            String[] keys=reader.readNext();

            if (keys !=null){
                String[] dataParts;
                while ((dataParts=reader.readNext()) !=null){
                    Map<String,String> testData=new HashMap<String,String>();
                    for (int i=0; i<keys.length; i++){

                       testData.put(keys[i],dataParts[i]);
                    }
                    list.add(new Object[]{testData});
                }
            }
            reader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }

}
