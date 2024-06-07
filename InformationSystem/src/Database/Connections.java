package Database;
import java.sql.*;
import Declaration.Variables;

public class Connections extends Variables {
    public void connecting(){
        try{
            dbname = "jdbc:derby://localhost:1527/StudentInformation";
            Connection conn = DriverManager.getConnection(dbname);
            System.out.println("Connected");
            System.out.println();
        }
        catch(Exception a){
            a.printStackTrace();
            System.out.println("Connection Failed");
        }
    }
}
