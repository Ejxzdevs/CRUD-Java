package UserEntry;

import Declaration.Variables;
import Pages.Home;
import java.sql.*;
import java.util.Scanner;

public class Login extends Variables {
    public void UserCredential(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        username = sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();
        System.out.println();
        
        CorrectCredentials(username, password);
    }
        
    public void CorrectCredentials(String username, String password ){
        try {
            conn = DriverManager.getConnection(dbname);
            query = "SELECT * FROM ACCOUNT WHERE username = ? AND password = ?";
            pstmnt = conn.prepareStatement(query);
            pstmnt.setString(1, username);
            pstmnt.setString(2, password);
            result = pstmnt.executeQuery();
            
            if (result.next()) {
                System.out.println("LOGIN SUCCESS");
                System.out.println();
                Home home = new Home();
                
                
            } else {
                System.out.println("Wrong username or password");
                System.exit(0);
            }
            
            // Close the resources
            result.close();
            pstmnt.close();
            conn.close();
        } catch(SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        } catch(Exception e) {
            // Handle other errors
            e.printStackTrace();
        }
    }
}
