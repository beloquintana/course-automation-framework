package database.query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeQuery {
    public static String createEmployeeTable(){
        return "CREATE TABLE Employee " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " phone VARCHAR(255), " +
                " email VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
    }

    public static String insertEmployee(int id, String name, int phone, String email){
        return "INSERT INTO Employee VALUES ("+ id + ", '"+ name +"', '"+ phone +"', '"+ email +"')";
    }

    public static String deleteEmployee(int id){
        return "DELETE FROM Employee WHERE id='"+ id +"'";
    }

    public static String selectEmployeeByName(String name){
        return "select * from Employee where name='" + name + "'";
    }

    public static String selectEmployeeById(int id){
        return "select * from Employee where id=" + id;
    }

    public static String selectEmployeeAll(){
        return "select * from Employee";
    }

    public static String updateEmployeeNameById(String nameToUpdate, int id){
        return "UPDATE Employee SET name = '"+ nameToUpdate +"' where id = "+ id;
    }
}
