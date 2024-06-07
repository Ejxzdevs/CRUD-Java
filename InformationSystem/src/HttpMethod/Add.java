package HttpMethod;
import Declaration.Variables;
import java.util.Scanner;
import java.sql.*;

public class Add extends Variables {
    Scanner sc = new Scanner(System.in);
    public void addStudent() {
    try {
        System.out.print("Enter First Name: ");
        firstName = sc.nextLine();
        System.out.print("Enter Middle Name: ");
        middleName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();
        System.out.print("Enter Age: ");
        age = sc.nextLine();
        System.out.print("Enter Gender: ");
        gender = sc.nextLine();
        System.out.print("Enter Course: ");
        course = sc.nextLine();
        System.out.print("Enter Year: ");
        syear = sc.nextLine();
        System.out.print("Enter Section: ");
        section = sc.nextLine();
        
        conn = DriverManager.getConnection(dbname);
        query = "INSERT INTO STUDENTS (FIRST_NAME, MIDDLE_NAME, LAST_NAME, Age, GENDER , COURSE, STUDENT_YEAR,SECTION) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        pstmnt = conn.prepareStatement(query);
        pstmnt.setString(1, firstName);
        pstmnt.setString(2, middleName);
        pstmnt.setString(3, lastName);
        pstmnt.setString(4, gender);
        pstmnt.setString(5, age);
        pstmnt.setString(6, course);
        pstmnt.setString(7, syear);
        pstmnt.setString(8, section);
        System.out.println();
        int rowsAffected = pstmnt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Inserted Data.");
        } else {
            System.out.println("Insert failed.");
        }
        } catch(SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        } catch(Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // Close the resources in finally block to ensure they are always closed
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
