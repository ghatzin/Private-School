/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Course {
    
    private String title;
    private Stream stream;
    private Type type;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Student> students;
    private List<Assignment> assignments;
    
    
    
    public Course(){
        
        students=new ArrayList<Student>();
        assignments=new ArrayList<Assignment>();
    }
    
    public Course(String title,Stream stream,Type type,String startDate,String endDate)
    {
        
        this();
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
    
    public void enrollStudent(Student student){
        
        students.add(student);
    }
    
    public List<Student> getStudents(){
        
        return students;
    }
    
    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
    }
 
    public List<Assignment> getAssignments(){
        return assignments;
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
