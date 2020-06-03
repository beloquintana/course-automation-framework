package helpers;

import database.query.EmployeeQuery;

import java.sql.*;

public class DataBaseHelper {
    private Connection connection;

    private String databaseURL = "jdbc:mysql://db4free.net:3306/automationarg";
    private String user = "autosel";
    private String password = "autosel1234";

    public DataBaseHelper(){

    }

    public void openConnectionToDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(databaseURL, user, password);
    }

    public void closeConnectionToDB() throws SQLException {
        if (connection != null)
            connection.close();
    }

    public ResultSet executeQuery(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public String getColumnValueById(ResultSet rs, String column, int id) throws SQLException {
        while(rs.next()){
            if(rs.getInt("id") == id){
                return rs.getString(column);
            }
        }
        return "";
    }

    public void showEmployeeTable(String query) throws SQLException {
        ResultSet rs = executeQuery(query);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            System.out.println(id+"\t"+name+"\t"+phone+"\t"+email+"\t");
        }
    }
}
