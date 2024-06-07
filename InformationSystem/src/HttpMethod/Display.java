package HttpMethod;
import java.sql.*;
import Declaration.Variables;

public class Display extends Variables {
    public void students(){
        try {
            conn = DriverManager.getConnection(dbname); 
            query = "SELECT * FROM STUDENTS";
            pstmnt = conn.prepareStatement(query);
            result = pstmnt.executeQuery();
             System.out.println("Students List");
             System.out.println();
             while (result.next()) {
                id = result.getInt("Student_ID");
                firstName = result.getString("First_Name");
                middleName = result.getString("Middle_Name");
                lastName = result.getString("Last_Name");
                age = result.getString("AGE");
                gender = result.getString("Gender");
                course = result.getString("Course");
                syear = result.getString("Student_Year");
                section = result.getString("Section");
                
                System.out.println("ID: " + id + 
                        " First Name: " + firstName + 
                        " Middle Name: " + middleName + 
                        " Last Name: " + lastName +
                        " Age: " + age +
                        " Gender: " + gender +
                        " Course: " + course +
                        " Year: " + syear +
                        " Section: " + section + 
                        " "
                        );
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
