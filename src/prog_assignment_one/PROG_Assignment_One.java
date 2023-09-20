package prog_assignment_one;

import java.util.Scanner;

/**
 *
 * @author Vivek Rajaram (ST10258124)
 */
public class PROG_Assignment_One {
    
    final static Scanner INPUT = new Scanner (System.in);
    static Student learner = new Student();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("STUDENT MANAGEMENT APPLICATION\n"
                                         + "*******************************************\n");
        menu();
        
    }
    
    public static void menu (){
        String selection;
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        selection = INPUT.nextLine();
        
        if (selection.equals("1")) {
            System.out.println("Please select one of the following menu items:\n"
                                             + "(1) Capture new student.\n"
                                             + "(2) Search for student.\n"
                                             + "(3) Delete student.\n"
                                             + "(4) Print student report.\n"
                                             + "(5) Exit Application");
            do {
                selection = "5";
                switch (INPUT.nextLine()){
                    case "1":
                        System.out.println("CAPTURE A NEW STUDENT\n****************************");
                        
                        System.out.print("Enter the student  id: ");
                        String studentID = INPUT.nextLine();
                        
                        System.out.print("Enter the student  name: ");
                        String studentName = INPUT.nextLine();
                        
                        //============================AGE VALIDATION==============================                       
                        System.out.print("Enter the student  age: ");
                        String studentAge = INPUT.nextLine();
                        
                        while (!learner.validateAge(studentAge)) {
                            System.out.print("You have entered a incorrect student age!!!\nPlease re-enter the student age >> ");
                            studentAge = INPUT.nextLine();
                        }
                        //======================================================================
                        
                        System.out.print("Enter the student  email: ");
                        String studentEmail = INPUT.nextLine();
                        
                        System.out.print("Enter the student  course: ");
                        String studentCourse = INPUT.nextLine();
                        
                        learner.SaveStudent(studentID, studentName, studentAge, studentEmail, studentCourse);
                        break;
//===============================================================================           
                        case "2":
                            System.out.print("Enter the student id to search: ");
                            String search = INPUT.nextLine();
                            
                            System.out.println("--------------------------------------------------------------------------");
                            
                            if (!learner.SearchStudent(search)){
                                System.out.println("Student with Student Id: " + search + " was not found!");
                            }
                            
                            System.out.println("--------------------------------------------------------------------------");
                            break;
//===============================================================================
                        case "3":
                            System.out.print("Enter student ID to delete: ");
                            String id = INPUT.nextLine();
                            
                            System.out.println("------------------------------------------------------------------------------");
                            
                            if (learner.DeleteStudent(id)) {
                                System.out.println("Are you sure you want to delete student " + id + " from the system? Yes (y) to delete.");
                                
                                if (learner.confirmDelete(INPUT.nextLine(), id)) {
                                    System.out.println("Student with Student Id: " + id + " WAS deleted!");
                                } else {
                                    System.out.println("Student with Student Id: " + id + " WAS NOT deleted!");
                                }
                            } else {
                                System.out.println("Student with Student Id: " + id + " was not found!");
                            }
                            System.out.println("---------------------------------------------------------------------");
                            break;
//===============================================================================
                        case "4":
                            learner.StudentReport();
                            break;
//===============================================================================
                        case "5":
                        learner.ExitStudentApplication();
//===============================================================================
                    default:
                        selection= "1";
                        System.out.println(" is not a valid option. Please try again.");
                        break;
                }
            } while (!selection.equals("5"));
            
        } else {
            learner.ExitStudentApplication();
        }
        menu();
    }
    
}