import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseHelper {

    public static Connection getDbConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) { ;
            e.printStackTrace();
        }

        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","rztk","p@ssw0rd");
        }
        catch (SQLException e){
            System.err.print(e);
            return null;
        }
    }

}
