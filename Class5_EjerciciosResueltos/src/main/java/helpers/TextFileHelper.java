package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileHelper {
    public static String getFileData(String filePath){
        String data = "";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                data += scanner.nextLine();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return data;
    }

    public static boolean isDataInFile(String filePath, String dataToFind){
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                if(data.contains(dataToFind))
                    return true;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return false;
    }

    public static int countDataInFile(String filePath, String dataToFind){
        int count = 0;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                if(data.contains(dataToFind))
                    count++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return count;
    }
}
