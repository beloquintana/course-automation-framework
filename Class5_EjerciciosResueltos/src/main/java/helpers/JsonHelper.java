package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper {
    private JsonArray jsonData;

    public void readJsonFile(String jsonFilePath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(jsonFilePath));
        JsonParser jsonParser = new JsonParser();
        jsonData = jsonParser.parse(reader).getAsJsonArray();
    }

    public String getTestData(String testName, String dataName){
        for (int i=0;i<jsonData.size();i++){
            JsonElement jsonElement = jsonData.get(i);
            String jsonTestName = jsonElement.getAsJsonObject().get("testName").getAsString();
            if(jsonTestName.equals(testName)){
                return jsonElement.getAsJsonObject().getAsJsonObject("properties").get(dataName).getAsString();
            }
        }
        return "";
    }
}
