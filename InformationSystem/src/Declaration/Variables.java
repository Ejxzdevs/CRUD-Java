package Declaration;
import java.sql.*;

public class Variables {
  
    protected String username,password;
    protected String query ;
    protected ResultSet  result = null ;
    protected Connection conn = null;
    protected PreparedStatement pstmnt = null ;
    protected String dbname = "jdbc:derby://localhost:1527/StudentInformation";
    protected int choice , suBchoice , id;
    protected String firstName , middleName , lastName , gender , course , section , age , colName , colVal , syear ;

}
