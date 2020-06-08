package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonTestDataHelper {

    private static Type listLoginType = new TypeToken<ArrayList<Login>>(){}.getType();

    public static Object[] getLoginTestData(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("resource/testdata/login/"+fileName+".json"));
        List<Login> loginList = new Gson().fromJson(reader, listLoginType);
        return loginList.toArray();
    }
}
