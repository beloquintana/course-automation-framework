package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Employee;
import model.Login;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonTestDataHelper {

    private Type listLoginType;
    private Type listEmployeeType;

    private static JsonTestDataHelper instance;

    private JsonTestDataHelper(){
        listLoginType = new TypeToken<ArrayList<Login>>(){}.getType();
        listEmployeeType = new TypeToken<ArrayList<Employee>>(){}.getType();
    }

    public static JsonTestDataHelper getInstance(){
        if (instance == null){
            //synchronized block to remove overhead
            synchronized (JsonTestDataHelper.class){
                if(instance==null){
                    // if instance is null, initialize
                    instance = new JsonTestDataHelper();
                }
            }
        }
        return instance;
    }

    public Object[] getLoginTestData(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("resource/testdata/login/"+fileName+".json"));
        List<Login> loginList = new Gson().fromJson(reader, listLoginType);
        return loginList.toArray();
    }

    public Object[] getEmployeeTestData(String fileName) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("resource/testdata/employee/"+fileName+".json"));
        List<Employee> employeeList = new Gson().fromJson(reader, listEmployeeType);
        return employeeList.toArray();
    }
}
