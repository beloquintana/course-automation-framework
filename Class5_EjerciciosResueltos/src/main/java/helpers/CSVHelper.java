package helpers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVHelper {
    private List<String[]> listCSVData;

    public void readCSVFile(String csvFilePath) throws IOException, CsvException {
        FileReader fileReader = new FileReader(csvFilePath);
        CSVReader csvReader = new CSVReader(fileReader);

        listCSVData = csvReader.readAll();
    }

    public void showCSVData(){
        for (int i=0;i<listCSVData.size();i++){
            String[] row = listCSVData.get(i);
            System.out.println("Row: " + (i+1));
            for (int j=0;j<row.length;j++){
                System.out.println(row[j]);
            }
        }
    }

    public String getTestData(String testName, String dataName){
        for (int i=0;i<listCSVData.size();i++){
            String[] row = listCSVData.get(i);
            if(row[0].equals(testName)){
                for (int j=1;j<row.length;j++){
                    String[] propertyArray =  row[j].split(":");
                    if(propertyArray[0].equals(dataName))
                        return propertyArray[1];
                }
            }
        }
        return "";
    }
}
