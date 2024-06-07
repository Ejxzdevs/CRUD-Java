package HttpMethod;
import Declaration.Variables;
import java.sql.*;
import java.util.Scanner;

public class Delete extends Variables {
    Scanner sc = new Scanner(System.in);
  
    public void deleteStudent(){
         System.out.println("Enter Student ID that you want to delete");
         System.out.print("Enter ID: ");
         id = sc.nextInt();
         sc.nextLine(); // Consume newline character
         System.out.print("Are you sure? you want to delete the Student ID: " +  id  + " [y]yes [n]No ? ");
         String confirm = sc.nextLine();
         
         if(confirm.equals("y")){
             executeDelete(id);
         }else if(confirm.equals("n")){
             deleteStudent();
        }else{
              System.out.println("Invalid input");
              deleteStudent();
         }
    }
     public void executeDelete(int id){
         try{
             conn = DriverManager.getConnection(dbname);
             query = "DELETE FROM STUDENTS WHERE STUDENT_ID = ? ";
             pstmnt = conn.prepareStatement(query);
             pstmnt.setInt(1, id);
             System.out.println();
             int rowsAffected = pstmnt.executeUpdate();
             
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) deleted.");
            } else {
                System.out.println("No rows deleted. The student with ID " + id + " might not exist.");
            }
             
         }catch(SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        } catch(Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
             try {
                if (result != null) {
                    result.close();
                }
                if (pstmnt != null) {
                    pstmnt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
         }
          
      }
}
