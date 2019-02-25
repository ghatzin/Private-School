/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author George
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class School
{
    
    private List<Course> courses;
    private List<Student> students;
    private List<Trainer> trainers;
   
    
    
    public School(){
        courses=new ArrayList<Course>();
        students=new ArrayList<Student>();
        trainers=new ArrayList<Trainer>();
        
        
    }
    
    public void addCourse(Course course){
        
        courses.add(course);
    }
    
    public void addStudent(Student student){
        
        students.add(student);
    }
    
    public void addTrainer(Trainer trainer){
        
        trainers.add(trainer);
    }
    
    public List<Student> getStudents(){
        
        return this.students;
    }
    
    public List<Course> getCourses()
    {
        return this.courses;
    }
    
    public List<Trainer> getTrainers()
    {
        return this.trainers;
    }
    
    public void assignStudentToCourse(Course course,Student student){
           
            course.addStudent(student);
    }
    
    public void assignTrainerToCourse(Course course,Trainer trainer)
    {
        course.addTrainer(trainer);
    }
    
    public void setAssignmentForCourse(Course course,Assignment assignment)
    {
        course.addAssignment(assignment);
    }
    
   
    public List<Student> getStudentsByCourse(String courseTitle)
    {
        Course course=getCourse(courseTitle);
        return course.getStudents();
    }
    
    public List<Trainer> getTrainersByCourse(String courseTitle){
        Course course=getCourse(courseTitle);
        return course.getTrainers();
    }
    
    public List<Assignment> getAssignmentsByCourse(String courseTitle){
        Course course=getCourse(courseTitle);
        return course.getAssignments();
    }
    
    public Course getCourse(int index)
    {
        index=index-1;
        Course course=courses.get(index);
        return course;
    }
    
    public Course getCourse(String courseName){
        
        Course course=null;
        for (Course course1:courses)
           if (course1.getTitle().equalsIgnoreCase(courseName))
               course=course1;
            
        return course;
    }
    
    
    public List<Student> getStudentsByCourse(Course course){
        
        return course.getStudents();
    }
    
    public List<Trainer> getTrainersByCourse(Course course){
        
        return course.getTrainers();
    }
    
    public List<Assignment> getAssignmentsByCourse(Course course)
    {
        return course.getAssignments();
    }
    
    
    public List<Assignment> getAssignmentsToBeSubmitForWeek(Course course,String date3){
        //LocalDate dateSubmission=LocalDate.parse(date3,DateTimeFormatter.ISO_LOCAL_DATE);
        List<Assignment> assignments=null;
        String mondayDate=getStartDateOftheWeek(date3);
        assignments=getAssigmentsFromMondayToFriday(mondayDate,course);
       
        return assignments;
    }
        
    
    
    public String getStartDateOftheWeek(String date3){
        LocalDate dateSubmission=LocalDate.parse(date3,DateTimeFormatter.ISO_LOCAL_DATE);
        
        String MondayDate=null;
        LocalDate date4=null;
        
        if (dateSubmission.getDayOfWeek()==DayOfWeek.MONDAY)
        {
            MondayDate=dateSubmission.toString();
            
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.TUESDAY)
        {
            date4=dateSubmission.minusDays(1);
            MondayDate=date4.toString();
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.WEDNESDAY)
        {
            date4=dateSubmission.minusDays(2);
            MondayDate=date4.toString();
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.THURSDAY)
        {
            date4=dateSubmission.minusDays(3);
            MondayDate=date4.toString();
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.THURSDAY)
        {
            date4=dateSubmission.minusDays(3);
            MondayDate=date4.toString();
        }
         else if (dateSubmission.getDayOfWeek()==DayOfWeek.THURSDAY)
        {
            date4=dateSubmission.minusDays(3);
            MondayDate=date4.toString();
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.FRIDAY){
           date4=dateSubmission.minusDays(4);
           MondayDate=date4.toString(); 
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.SUNDAY){
            date4=dateSubmission.minusDays(6);
            MondayDate=date4.toString(); 
        }
        
        return MondayDate;
    } 
    
    
    public String getLastDay(String date5){
        
        LocalDate MondayDate=LocalDate.parse(date5,DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate FridayDate=MondayDate.plusDays(4);
        
        return FridayDate.toString();
    }
     
     private List<Assignment> getAssigmentsFromMondayToFriday(String date1,Course course){
        
        List<Assignment> assignments1=new ArrayList<Assignment>(); 
        LocalDate startDate=LocalDate.parse(date1,DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate submissionDay=null;
        LocalDate[] weekDays=new LocalDate[5];
        
        for (int i=0;i<5;i++)
        {
            if (i==0)
                submissionDay=startDate;
            else
                submissionDay=submissionDay.plusDays(1);
            
            weekDays[i]=submissionDay;
        }
            
        for (int i=0;i<weekDays.length;i++)
            for (int j=0;j<course.getAssignments().size();j++)
            {
                if (weekDays[i].isEqual(course.getAssignments().get(j).getSubmissionDate()))
                     assignments1.add(course.getAssignments().get(j));
            }
    
        return assignments1;
    }   
       
     
     public List<Student> getStudentsEnrollInTwoCourses(Course course1,Course course2){
         
            List<Student> commonStudents=new ArrayList<Student>();
            List<Student> course1Students=course1.getStudents();
            List<Student> course2Students=course2.getStudents();
            
           for (int i=0;i<course1Students.size();i++){
               for (int j=0;j<course2Students.size();j++)
                   if (course1Students.get(i).toString().equalsIgnoreCase(course2Students.get(j).toString()))
                       commonStudents.add(course1Students.get(i));
          }
           
           return commonStudents;
     }
     
     public void getStudentsEnrollInMoreCourses()
     {
         List<Student> cStudents=null;
         Course course1=null;
         Course course2=null;
         for (int i=0;i<courses.size()-1;i++)
         {
             course1=courses.get(i);
             course2=courses.get(i+1);
             cStudents=getStudentsEnrollInTwoCourses(course1,course2);
            
         }
         
         if (cStudents!=null){
              for (int j=0;j<cStudents.size();j++)
                  System.out.println(cStudents.get(j).toString()+ "has enrolled to " + course1+" "+course2);
          }         
     }
}   
    
   
    
  
     
    
    

