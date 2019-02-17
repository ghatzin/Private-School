/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import entities.*;

/**
 *
 * @author George
 */
public class School {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Stream javaStream=Stream.JAVA;
        Stream csharpStream=Stream.CSHARP;
        Type fullTime=Type.FullTime;
        Type partTime=Type.PartTime;
        
        System.out.println(javaStream.name());
        System.out.println(csharpStream.toString());
        
        Student student1=new Student("George","Chatzinikolaou","23/01/1978",2.500);
        Student student2=new Student("Despoina","Chatzinikolaou","06/12/1979",2.500);
        Course course1=new Course("Junior Full Stack Developer",javaStream,fullTime,"2019-01-21","2019-03-31");
        Course course2=new Course("Junior Full Stack Developer",csharpStream,partTime,"2019-01-21","2019-03-31");
        Assignment assignment1=new Assignment("Private School","Implementation of a private school","2019-02-25","23:00:00",0.80,0.20);
        Assignment assignment2=new Assignment("Private Hospital","Implementation of a private hospital","2019-02-25","23:00:00",0.80,0.20);
       
        System.out.println(assignment1.getSubmissionDateTimeAsString());
        course1.enrollStudent(0, student1);
        course1.enrollStudent(1, student2);
        course2.enrollStudent(0, student1);
        course2.enrollStudent(1, student2);
        
        Stream stream=course1.getStream();
        System.out.println(stream.toString());
          
        System.out.println(course1.getStartDateAsString());
        System.out.println(course2.getEndDateAsString());
       
        System.out.println(course1.getStartDate().isEqual(course2.getStartDate()));
        
        course1.addAssignment(0, assignment1);
        course2.addAssignment(1, assignment2);

        printStudentsPerCourse(course1);
        
        
    }
    
    public static void printStudentsPerCourse(Course course)
    {
        for (int i=0;i<course.getStudents().length;i++){
            if (course.getStudent(i)!=null)
                System.out.println(course.getStudent(i).toString());
            else
               break;
        }
    }
    
}
