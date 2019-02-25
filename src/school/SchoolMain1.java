/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;


import entities.*;
import java.util.*;
/**
 *
 * @author George
 */
public class SchoolMain1 {

    static School school;
    
    public static void main(String[] args) {
        
        getSyntheticData();
        Scanner input=new Scanner(System.in);
        Scanner newInput=new Scanner(System.in);
        
        int i=0;
        do
          {
            GUI.clearConsole();
            GUI.displayReports();
            if (i>0){
                input.reset();
                input=newInput;
            }
            do
            {
                
              GUI.getUserChoise(input,1,8);
              System.out.println("You should give a number between 1 and 8");
            }
            while(!(GUI.checkIFNumberIsCorrectChoice(1,8)));
            
            switch(GUI.getChoiseOfUSer())
            {
                case 1:printCourses();
                       break;
                case 2:printStudents();
                       break;
                case 3:printTrainers();
                       break;
                case 4:for (Course course:school.getCourses())
                            printStudentsPerCourse(course);
                       break;
                case 5:for (Course course:school.getCourses())
                            printTrainersPerCourse(course);
                       break;
                case 6:for (Course course:school.getCourses())
                            printAssignmentsPerCourse(course);
                       break;
                case 7:for (Course course:school.getCourses())
                            printAssignmentsHaveToSubmitForWeek(course,"2019-02-22");
                       break;
                case 8:PrintStudentsWhoHaveEnrollToMoreThanOneCourse();
                       break;
            } 
            System.out.println("IF you want to return to the main menu press any key. IF you want to quit type quit");
            i++;
         }while(!(input.hasNext("quit")));
        
    
       
    }
    
    
    public static void getSyntheticData()
    {
       
        
        school=new School();
        
        Student student1=new Student("George","Chatzinikolaou",41,2.500);
        Student student2=new Student("Despoina","Chatzinikolaou",39,2.500);
        Course course1=new Course("JAVABC7","java","fullTime","2019-01-21","2019-03-31");
        Course course2=new Course("CSHARPBC7","csharp","partTime","2019-01-21","2019-03-31");
        Course course3=new Course("PHPBC7","PHP","fulltime","2019-01-21","2019-03-31");
        Assignment assignment1=new Assignment("Private School","Implementation of a private school","2019-02-18","23:00:00",0.80,0.20);
        Assignment assignment2=new Assignment("Private Hospital","Implementation of a private hospital","2019-02-18","23:00:00",0.80,0.20);
        Assignment assignment3=new Assignment("Private School","Implementation of a private school","2019-02-20","23:00:00",0.80,0.20);
        Assignment assignment4=new Assignment("Private Hospital","Implementation of a private hospital","2019-02-21","23:00:00",0.80,0.20);
        Assignment assignment5=new Assignment("Private School","Implementation of a private school","2019-02-22","23:00:00",0.80,0.20);
        Trainer trainer1=new Trainer("Tasos","Loulakis","Java");
        Trainer trainer2=new Trainer("George","Pasparakis","C#");
        
        school.addStudent(student1);
        school.addStudent(student2);
        school.addCourse(course1);
        school.addCourse(course2);
        school.addCourse(course3);
        school.addTrainer(trainer1);
        school.addTrainer(trainer2);
        
        school.assignStudentToCourse(course3, student1);
        school.assignStudentToCourse(course3, student2);
        school.assignStudentToCourse(course1, student1);
        school.assignStudentToCourse(course2, student1);
        school.assignStudentToCourse(course1, student2);
        school.assignStudentToCourse(course2, student2);
        
        school.setAssignmentForCourse(course1, assignment1);
        school.setAssignmentForCourse(course1, assignment2);
        school.setAssignmentForCourse(course1, assignment3);
        school.setAssignmentForCourse(course1, assignment4);
        school.setAssignmentForCourse(course1, assignment5);
        
        school.setAssignmentForCourse(course2, assignment1);
        school.setAssignmentForCourse(course2, assignment2);
        school.setAssignmentForCourse(course2, assignment3);
        school.setAssignmentForCourse(course2, assignment4);
        school.setAssignmentForCourse(course2, assignment5);
        
        school.assignTrainerToCourse(course1, trainer1);
        school.assignTrainerToCourse(course1, trainer2);
        school.assignTrainerToCourse(course2, trainer1);
        school.assignTrainerToCourse(course2, trainer2);
        
        
    }
    
    public static void printStudents()
    {
        List<Student> students=school.getStudents();
        if (!(students.isEmpty())){
            for (Student student:students)
                System.out.println(student);
        }
        else
        {
            System.out.println("Not students yet");
        }
    }

    public static void printTrainers()
    {
        
        List<Trainer> trainers=school.getTrainers();
        if (!(trainers.isEmpty())){
            for (Trainer trainer:trainers)
                System.out.println(trainer);
        }
        else
        {
            System.out.println("School has not hired trainers yet");
        }
    }
    
    public static void printCourses(){
        List<Course> courses=school.getCourses();
        if(!(courses.isEmpty())){
            for (Course course:courses)
                System.out.println(course);
        }
        else
        {
            System.out.println("There are not have creted courses yet");
        }
    }

    public static void printStudentsPerCourse(Course course)
    {
        List<Student> students=school.getStudentsByCourse(course);
        
        if(!(students.isEmpty()))
        {
            System.out.println("Students who have enrolled in Course "+course.getTitle());
            for (Student student:students)
                System.out.println(student);
        }
        else
        {
            System.out.println("No stduents have enroll in course "+course.getTitle()+" yet");
        }
    }
    
    public static void printTrainersPerCourse(Course course)
    {
        List<Trainer> trainers=school.getTrainersByCourse(course);
        
        if (!(trainers.isEmpty())){
            System.out.println("For course: "+course.getTitle()+" trainers are the following:");
            for (Trainer trainer:trainers)
                System.out.println(trainer);
        }
        else
        {
            System.out.println("No trainers have been assigned to course "+course.getTitle());
        }
    }
    
    public static void printAssignmentsPerCourse(Course course)
    {
        List<Assignment> assignments=school.getAssignmentsByCourse(course);
        if (!(assignments.isEmpty()))
        {
            System.out.println("For course: "+course.getTitle()+" assignemnts are the following:");
            for (Assignment assignment:assignments)
                System.out.println(assignment.toString());
        }
        else
        {
            System.out.println("For course: "+course.getTitle()+" not assignemnts yet");
        }
    }
    
    public static void printAssignmentsHaveToSubmitForWeek(Course course,String date)
    {
        System.out.println("");
        String mondayDate=school.getStartDateOftheWeek(date);
        String lastDate=school.getLastDay(mondayDate);
        String courseTitle=course.getTitle();
        List<Assignment> weekAssignments=school.getAssignmentsToBeSubmitForWeek(course,date);
        if (!(weekAssignments.isEmpty())){
            System.out.println("Assignments should be submited from Monday "+mondayDate+" until Friday "+lastDate+"for course "+courseTitle+" are the following:");
            for (Assignment assignment:weekAssignments)
                System.out.println(assignment.toString());
        }
        else
        {
            System.out.println("No assignments for the course "+course.getTitle());
        }
    }
    
    public static void PrintStudentsWhoHaveEnrollToMoreThanOneCourse(){
        
        school.getStudentsEnrollInMoreCourses();

    }
   
    
    
        
}




