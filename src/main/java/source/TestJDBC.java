package source;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    private static String url="jdbc:mysql://localhost:3306/customers?useSSL=false&serverTimezone=UTC";
    private static String userName="root";
    private static String password="1";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection= DriverManager.getConnection(url,userName,password)){
            System.out.println("Successful");
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
