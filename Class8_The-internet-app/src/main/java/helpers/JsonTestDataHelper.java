package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonTestDataHelper {
    private static JsonTestDataHelper instance;

    private static final Logger logger = LogManager.getLogger(JsonTestDataHelper.class);

    private JsonTestDataHelper(){
    }

    public static JsonTestDataHelper getInstance(){
        if (instance == null){
            //synchronized block to remove overhead
            synchronized (JsonTestDataHelper.class){
                if(instance==null){
                    // if instance is null, initialize
                    instance = new JsonTestDataHelper();
                    logger.info("JsonTestDataHelper created");
                }
            }
        }
        return instance;
    }

    public <T> Object[] geTestData(String filePath, Class<T> clazz) throws FileNotFoundException {
        logger.info("filePath: " + filePath);
        JsonReader reader = new JsonReader(new FileReader(filePath));
        List<T> testDataList = new Gson().fromJson(reader, TypeToken.getParameterized(ArrayList.class, clazz).getType());
        logger.info("geTestData: " + testDataList.toString());
        return testDataList.toArray();
    }
}
