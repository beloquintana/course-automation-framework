package databases;

import database.query.EmployeeQuery;
import helpers.DataBaseHelper;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class DataBaseTests {
    private DataBaseHelper dataBaseHelper;
    private int idEmployeeToAdd;

    @BeforeClass
    public void setUpDB() throws SQLException, ClassNotFoundException {
        dataBaseHelper = new DataBaseHelper();
        dataBaseHelper.openConnectionToDB();
        dataBaseHelper.showEmployeeTable(EmployeeQuery.selectEmployeeAll());
    }

    @Test
    public void testAddEmployee() throws SQLException {
        RandomString session = new RandomString();
        String name = session.nextString();
        Random rand = new Random();
        int upperbound = 500;
        idEmployeeToAdd = rand.nextInt(upperbound);
        int phone = rand.nextInt(upperbound);

        dataBaseHelper.executeUpdate(EmployeeQuery.insertEmployee(idEmployeeToAdd, name, phone, "admin@gmail.com"));
        boolean isEmployeeAdded = dataBaseHelper.executeQuery(EmployeeQuery.selectEmployeeById(idEmployeeToAdd)).next();

        Assert.assertTrue(isEmployeeAdded);
    }

    @Test
    public void testDeleteEmployee() throws SQLException {
        RandomString session = new RandomString();
        String name = session.nextString();
        Random rand = new Random();
        int upperbound = 500;
        int idEmployeeToAdd = rand.nextInt(upperbound);
        int phone = rand.nextInt(upperbound);

        dataBaseHelper.executeUpdate(EmployeeQuery.insertEmployee(idEmployeeToAdd, name, phone, "admin@gmail.com"));
        boolean isEmployeeAdded = dataBaseHelper.executeQuery(EmployeeQuery.selectEmployeeById(idEmployeeToAdd)).next();
        Assert.assertTrue(isEmployeeAdded);

        dataBaseHelper.executeUpdate(EmployeeQuery.deleteEmployee(idEmployeeToAdd));
        boolean employeeExist = dataBaseHelper.executeQuery(EmployeeQuery.selectEmployeeById(idEmployeeToAdd)).next();
        Assert.assertFalse(employeeExist);
    }

    @Test
    public void testUpdateEmployee() throws SQLException {
        RandomString session = new RandomString();
        String expectedName = session.nextString();
        int idEmployeeToUpdate = 3;

        dataBaseHelper.executeUpdate(EmployeeQuery.updateEmployeeNameById(expectedName, idEmployeeToUpdate));
        ResultSet rs = dataBaseHelper.executeQuery(EmployeeQuery.selectEmployeeById(idEmployeeToUpdate));
        String actualName = dataBaseHelper.getColumnValueById(rs,"name", idEmployeeToUpdate);

        Assert.assertEquals(expectedName, actualName);
    }

    @AfterClass
    public void tearDownDB() throws SQLException {
        if(dataBaseHelper != null){
            dataBaseHelper.executeUpdate(EmployeeQuery.deleteEmployee(idEmployeeToAdd));
            dataBaseHelper.showEmployeeTable(EmployeeQuery.selectEmployeeAll());
            dataBaseHelper.closeConnectionToDB();
        }

    }
}
