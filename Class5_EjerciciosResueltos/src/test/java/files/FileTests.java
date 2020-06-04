package files;

import helpers.TextFileHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileTests {
    @Test
    public void testEmployeeLogsIsNotEmpty(){
        String dataLog = TextFileHelper.getFileData("resource/files/employee_logs.txt");
        Assert.assertNotNull(dataLog);
    }

    @Test
    public void testEmployeeLogsWithOutErrors(){
        boolean error = TextFileHelper.isDataInFile("resource/files/employee_logs.txt", "Error");
        Assert.assertFalse(error);
    }

    @Test
    public void testEmployeeLogsErrorsCount(){
        int errorCount = TextFileHelper.countDataInFile("resource/files/employee_logs.txt", "Error");
        Assert.assertEquals(errorCount, 2);
    }
}
