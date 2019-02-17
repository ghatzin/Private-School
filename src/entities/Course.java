/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Course {
    
   /* public enum Stream {JAVA,
             CSHARP{
                
                @Override
                public String toString(){
                    return "C#"; 
                }
             }
            };

    public enum Type {FullTime,PartTime};*/
    
    private String title;
    private Stream stream;
    private Type type;
    private LocalDate startDate;
    private LocalDate endDate;
    private Student [] students;
    private Assignment[] assignments;
    
    
    
    public Course(){
        
        students=new Student[30];
        assignments=new Assignment[2];
    }
    
    public Course(String title,Stream stream,Type type,String startDate,String endDate)
    {
        
        students=new Student[30];
        assignments=new Assignment[2];
        this.title=title;
        this.stream=stream;
        this.type=type;
        
        this.startDate=LocalDate.parse(startDate,DateTimeFormatter.ISO_LOCAL_DATE);
        this.endDate=LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public void enrollStudent(int index,Student student){
        
        students[index]=student;
    }
    
    public Student[] getStudents(){
        
        return students;
    }
    
    public void addAssignment(int index,Assignment assignment)
    {
        assignments[index]=assignment;
    }
 
    public Assignment[] getAssignments(){
        return assignments;
    }
    
    public Student getStudent(int index){
        
        return students[index];
    }
    
    public String getStartDateAsString(){
        
        return getStartDate().getDayOfMonth()+" "+
               getStartDate().getDayOfWeek()+" "+
               getStartDate().getYear();
    
    }
    
    public String getEndDateAsString(){
        
        return getEndDate().getDayOfMonth()+" "+
               getEndDate().getDayOfWeek()+" "+
               getEndDate().getYear();
    
    }
   
}
