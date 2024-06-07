package Pages;
import HttpMethod.Display;
import HttpMethod.Add;
import UserEntry.Logout;
import HttpMethod.Delete;
import HttpMethod.Update;
import Declaration.Variables;
import java.util.Scanner;



public class Home extends Variables {
      Scanner sc = new Scanner(System.in);
      Logout logout = new Logout();
      Display display = new Display();
      Add add = new Add();
      Delete del = new Delete();
      Update update = new Update();
      
    public void chooseOption(){
        System.out.println("[1]Show Students List");
        System.out.println("[2]LogOut");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        choice = sc.nextInt();
        System.out.println();
        
        switch(choice){
          case 1:
              display.students();
              SubchooseOption();
              break;
          case 2:  
              logout.Logout();
              break;
          default:
                System.out.println("Invalid Input");
        }
        
    }
    
    public void SubchooseOption(){
        System.out.println();
        System.out.println("[1]ADD");
        System.out.println("[2]SHOW");
        System.out.println("[3]UPDATE");
        System.out.println("[4]DELETE");
        System.out.println("[5]LogOut");
        System.out.println();
        System.out.print("Enter Your Choice: ");
        suBchoice = sc.nextInt();
        
        switch(suBchoice){
          case 1:
              add.addStudent();
              SubchooseOption();
              break;
          case 2:  
              display.students();
              SubchooseOption();
              break;
          case 3:
              update.updateStudent();
              SubchooseOption();
              break;
          case 4:
              del.deleteStudent();
              SubchooseOption();
              break;
          case 5:
              logout.Logout();
              break;
          default:
                System.out.println("Invalid Input");
        }
        
        
      
        
    }
        
    public Home(){
        System.out.println("Welcome to Student Management System");
        System.out.println();
        chooseOption();
     
              
    }
    public void menu(){
        System.out.println();
        System.out.println("[1]Show Students List");
        System.out.println("[2]LogOut");
        
    }
}
