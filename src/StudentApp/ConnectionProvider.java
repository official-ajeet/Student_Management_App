package StudentApp;

import java.sql.Connection;
import java.sql.DriverManager;

//this is to create connection to db
public class ConnectionProvider {
    static Connection con;
    public static Connection createConnection(){//static to call directly, typed Connection to return con;

        try{
            //load the driver - not necessary in j7
            //create connection
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "1234";

            con = DriverManager.getConnection(url,user,password);

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
