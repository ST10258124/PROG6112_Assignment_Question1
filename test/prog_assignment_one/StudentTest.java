package prog_assignment_one;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vivek Rajaram (ST10258124)
 */
public class StudentTest{
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SaveStudent method, of class Student.
       }
*/
    @Test
    public void TestSaveStudent() {
        System.out.println("SaveStudent");
        Student instance = new Student();
        
        instance.SaveStudent("12345", "Bob Ross", "18", "bobross@gmail.com", "DLSS");
        
        boolean result = (instance.studentID.get(0).equals("12345")) && (instance.studentName.get(0).equals("Bob Ross")) && (instance.studentAge.get(0) == 18) && (instance.studentEmail.get(0).equals("bobross@gmail.com")) && (instance.studentCourse.get(0).equals("DLSS"));
        assertEquals(true, result);
    }

    /**
     * Test of SearchStudent method, of class Student.
     */
    @Test
    public void TestSearchStudent() {
        System.out.println("SearchStudent");
        Student instance = new Student();
        
        instance.SaveStudent("12345", "Bob Ross", "18", "bobross@gmail.com", "DLSS");
        
        boolean result = instance.SearchStudent("12345");
        
        assertEquals(true, result);
    }
    
    @Test
    public void TestSearchStudent_StudentNotFound() {
        System.out.println("SearchStudent_StudentNotFound");
        Student instance = new Student();
        
        boolean result = instance.SearchStudent("12345");
        
        assertEquals(false, result);
    }
//
    /**
     * Test of DeleteStudent method, of class Student.
     */
    
    @Test
    public void TestDeleteStudent() {
        System.out.println("DeleteStudent");
        Student instance = new Student();
        
        instance.SaveStudent("12345", "Bob Ross", "18", "bobross@gmail.com", "DLSS");
        String testSearch = "12345";
        boolean result;
        
        if (instance.DeleteStudent(testSearch)) {
            result = (instance.confirmDelete("y", testSearch));
        } else {
            result = false;
        }
        
        assertEquals(true, result);
    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound() {
        System.out.println("DeleteStudent");
        Student instance = new Student();
        
        String testSearch = "12345";
        assertEquals(false, instance.DeleteStudent(testSearch));
    }
    
    @Test
    public void TestStudentAge_StudentAgeValid(){
        System.out.println("TestStudentAge_StudentAgeValid");
        Student instance = new Student();
        
        String ageOfStudent = "18";
        
        boolean result = instance.validateAge(ageOfStudent);
        assertEquals(true, result);
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalid(){
        System.out.println("TestStudentAge_StudentAgeInvalid");
        Student instance = new Student();
        
        String ageOfStudent = "-15";
        
        boolean expResult = true;
        boolean result = false;
        
        if (!instance.validateAge(ageOfStudent)) {
            if (ageOfStudent.matches("(-)?\\d+")) {
                result = Integer.parseInt(ageOfStudent) < 16;
            }
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter(){
        System.out.println("TestStudentAge_StudentAgeInvalidCharacter");
        Student instance = new Student();
        
        String ageOfStudent = "abc";
        
        boolean result = false;
        
        if (!instance.validateAge(ageOfStudent)) {
            result = ageOfStudent.matches("\\d+");
        }
        assertEquals(false, result);
    }
}