/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author George
 */
public class StudentAsignments {
    
    private Student student;
    private List<Assignment> assignments;
    
    
    public StudentAsignments(){
        assignments=new ArrayList<Assignment>();
    }
    
    public StudentAsignments(Student student){
        
        this.student=student;
        assignments=new ArrayList<Assignment>();   
    }
    
    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }
    
    public List<Assignment> getAssigmentsByDateOfSubmission(String date3){
        LocalDate dateSubmission=LocalDate.parse(date3,DateTimeFormatter.ISO_LOCAL_DATE);
        List<Assignment> assignments=null;
        LocalDate date4=null;
        if (dateSubmission.getDayOfWeek()==DayOfWeek.SATURDAY){
           date4=dateSubmission.minusDays(5);
           assignments=getAssigmentsFromMondayToFriday(date4.toString());
           return assignments;
        }
        else if (dateSubmission.getDayOfWeek()==DayOfWeek.SUNDAY){
            date4=dateSubmission.minusDays(6);
            assignments=getAssigmentsFromMondayToFriday(date4.toString());
            return assignments;
        }
        else
        {
            
            assignments=getAssigmentsBySubmissionDay(dateSubmission.toString());
            return assignments;
        }
    }
    
     public List<Assignment> getAssigmentsFromMondayToFriday(String date1){
        
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
            for (int j=0;j<assignments.size();j++)
            {
                if (weekDays[i].isEqual(assignments.get(j).getSubmissionDate()))
                     assignments1.add(assignments.get(j));
            }
    
        return assignments1;
    }   
       
    public List<Assignment> getAssigmentsBySubmissionDay(String dateOfSubmission){
       LocalDate submissionDate=LocalDate.parse(dateOfSubmission,DateTimeFormatter.ISO_LOCAL_DATE);
       List<Assignment> assignments1=new ArrayList<Assignment>();
       for (int j=0;j<assignments.size();j++)
       {
                if (assignments.get(j).getSubmissionDate().isEqual(submissionDate))
                     assignments1.add(assignments.get(j));
        }
       
       return assignments1;
   }
    
    public void printAssignements(String date)
    {
        List<Assignment> ass=getAssigmentsByDateOfSubmission(date);
        
        System.out.println(ass.size());
        
        for (int i=0;i<ass.size();i++)
            System.out.println(ass.get(i).toString());
        
    } 
        
}
