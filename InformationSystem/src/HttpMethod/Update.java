package HttpMethod;
import Declaration.Variables;
import java.sql.*;
import java.util.Scanner;


public class Update extends Variables {
    Scanner sc = new Scanner(System.in);
    
    
    public void executeUpdate(int id){
        try{
            conn = DriverManager.getConnection(dbname); 
            query = "SELECT * FROM STUDENTS WHERE Student_ID = ?";
            pstmnt = conn.prepareStatement(query);
            pstmnt.setInt(1, id);
            result = pstmnt.executeQuery();
            while (result.next()) {
                System.out.println("STUDENT INFORMATION");
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
                        " Firstname: " + firstName + 
                        " Middlename: " + middleName + 
                        " Lastname: " + lastName +
                        " Age: " + age +
                        " Gender: " + gender +
                        " Course: " + course +
                        " Year: " + syear +
                        " Section: " + section + 
                        " "
                        );
            }
            System.out.println();
            System.out.println("Choose column that you want to update:");
            System.out.println("[1] Firstname [2] Middlename [3] Lastname [4] Age [5] Gender [6] Course [7] year [8] Section");
            System.out.print("Enter Your Choice: ");
            suBchoice = sc.nextInt();
            
            switch(suBchoice){
                case 1:
                    colName = "First_Name";
                    break;
                case 2:
                    colName = "Middle_Name";
                    break;
                case 3:
                    colName = "Last_Name";
                    break;
                case 4:
                    colName = "Age";
                    break;
                case 5:
                    colName = "Gender";
                    break;
                case 6:
                    colName = "Course";
                    break;
                case 7:
                    colName = "Student_Year";
                    break;
                case 8:
                    colName = "Section";
                    break;    
                default:
                     System.out.println("Invalid Input"); 
            }
            sc.nextLine(); // Consume newline character
            System.out.print("Enter the value for " + colName + " : ");
            colVal = sc.nextLine();
            System.out.println();
            try{
                query = "UPDATE STUDENTS SET " + colName + " = ? WHERE STUDENT_ID = ?";
                pstmnt = conn.prepareStatement(query);
                pstmnt.setObject(1, colVal); 
                pstmnt.setInt(2, id);
                System.out.println();
                int rowsAffected = pstmnt.executeUpdate();

               if (rowsAffected > 0) {
                    System.out.println("Successfully updated column " + colName + " where Student ID = " + id + "");
                    System.out.println();
                    System.out.print("Do you want to update more column for Student ID = " + id + "? [y]yes [n]no? ");
                    String con = sc.nextLine();
                    if(con.equals("y")){
                        executeUpdate(id);
                     }else if(con.equals("n")){
                       
                        
                    }else{
                        System.out.print("Invalid Input");
                    }
                   
               } else {
                   System.out.println("updating failder");
               }
               
            } catch(SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
            } catch(Exception e) {
                // Handle other errors
                e.printStackTrace();
            }
 
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
    
    public void updateStudent(){
        System.out.println("Enter Student ID that you want to update");
        System.out.print("Enter ID: ");
        id = sc.nextInt();
        System.out.println();
        executeUpdate(id);
    }
    
}
