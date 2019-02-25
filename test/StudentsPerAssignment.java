/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import entities.*;

/**
 *
 * @author George
 */
public class StudentsPerAssignment {
    
        Stream javaStream=Stream.JAVA;
        Stream csharpStream=Stream.CSHARP;
        Type fullTime=Type.FullTime;
        Type partTime=Type.PartTime;
        Student student1=new Student("George","Chatzinikolaou","23/01/1978",2.500);
        Student student2=new Student("Despoina","Chatzinikolaou","06/12/1979",2.500);
        Course course1=new Course("Junior Full Stack Developer",javaStream,fullTime,"2019-01-21","2019-03-31");
        Course course2=new Course("Junior Full Stack Developer",csharpStream,partTime,"2019-01-21","2019-03-31");
        Assignment assignment1=new Assignment("Private School","Implementation of a private school","2019-02-22","23:00:00",0.80,0.20);
        Assignment assignment2=new Assignment("Private Hospital","Implementation of a private hospital","2019-02-22","23:00:00",0.80,0.20);
    
    public StudentsPerAssignment() {
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

    @Test
    public void printStudentByAssignmentDate(){
        Student [] students=course1.getEnrolledStudents();
        Assignment[] assignments=course1.getAssignments();
        getStudentsByAssignmentDay(); 
        
        
    }  
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
