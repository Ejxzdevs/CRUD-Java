package informationsystem;
import UserEntry.Login;
import Database.Connections;


public class InformationSystem {
      
        
    public static void main(String[] args) {
        Connections connect = new Connections();
        Login login = new Login();
        
        connect.connecting();
        System.out.println("User Login");
        System.out.println();     
        login.UserCredential();
        
    }
    
}