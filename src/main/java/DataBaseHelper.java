import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseHelper {

    public static Connection getDbConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try{
            Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","rztk","p@ssw0rd");
            return conn;
        }
        catch (SQLException e){
            System.err.print(e);
            return null;
        }
    }

}
