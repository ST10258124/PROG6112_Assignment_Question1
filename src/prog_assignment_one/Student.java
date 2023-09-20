package prog_assignment_one;

import java.util.ArrayList;

/**
 *
 * @author Vivek Rajaram (ST10258124)
 */
public class Student{
    
     ArrayList <String> studentID = new ArrayList<String>();
     ArrayList <String> studentName = new ArrayList<String>();
     ArrayList <Integer> studentAge = new ArrayList<>();
     ArrayList <String> studentEmail = new ArrayList<String>();
     ArrayList <String> studentCourse = new ArrayList<String>();
    
    int index = 0;
    
    public void SaveStudent(String id, String name, String age, String email, String course){
        studentID.add(id);
        studentName.add(name);
        studentAge.add(Integer.parseInt(age));
        studentEmail.add(email);
        studentCourse.add(course);
    }
    
    public boolean SearchStudent(String search){
        //returns true when what the user searched for is found. false if does not exist
        if (search(search)) {
            System.out.println(generateReport(index));
            return true;
        }
        
        return false;
    }
    
    public boolean DeleteStudent(String deleteID){      
        return (search(deleteID));
    }
    
    public void StudentReport(){
        for (int i = 0; i < studentID.size(); i++) {
            System.out.println("STUDENT " + ((int) i + 1) + 
                                                 "\n-------------------------------------------------------\n" +
                                                 generateReport(i) +
                                                 "\n-------------------------------------------------------");
        }
    }
    
    public void ExitStudentApplication(){
        System.exit(0);
    }
//====================================EXTRAS======================================    
    public boolean validateAge(String ageOfStudent){
        return (ageOfStudent.matches("(\\d)&&[^0-1][0-5]||[1][6-9]||[2-9][0-9]||[1-9](\\d){2,}"));
        /* "\\d" indicates numbers only. . . "+" indicates can occur once or more
            "[^0-1][0-5]" indicates that a 0 or 1 may not be placed before a number from 0 to 5
            "[1][6-9]" indicates that a 1 may only be placed before numbers from 6 to 9
            "[1][6-9]" indicates that a number from 2 to 9 may be placed before numbers from 0 to 9
            "[1-9](\\d){2,}" indicates that a number from 1-9 can be followed by any 2 or more numerical values
            added the last one since upper limit on age was not specified */
    }
    
    private boolean search (String searchID){ 
        if (studentID.isEmpty()) return false;
        
        index = 0;
         
        do {
            if (studentID.get(index).equals(searchID)) return true;
            index++;
        } while (index < studentID.size());
        
        return false;
    }
    
    private String generateReport(int targetindex){ //also used for the search method. Student report method will execute this method in loop
        return ("STUDENT ID: " + studentID.get(targetindex) +
                      "\nSTUDENT NAME: " + studentName.get(targetindex) +
                      "\nSTUDENT AGE: " + studentAge.get(targetindex) +
                      "\nSTUDENT EMAIL: " + studentEmail.get(targetindex) +
                      "\nSTUDENT COURSE: " + studentCourse.get(targetindex));
    }
    
    public boolean confirmDelete (String confirmation, String idToDelete){
        System.out.println("Are you sure you want to delete student " + idToDelete + " from the system?\nYes (y) to delete");
        
        if (confirmation.equalsIgnoreCase("y")){
                studentID.remove(index);
                studentName.remove(index);
                studentAge.remove(index);
                studentEmail.remove(index);
                studentCourse.remove(index);
                return true;
            } else return false;
    }
}