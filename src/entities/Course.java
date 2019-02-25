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
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Student> students;
    private List<Assignment> assignments;
    private List<Trainer> trainers;
    
    
      
    public Course(String title,String stream,String type,String startDate,String endDate)
    {
        
        this.students=new ArrayList<Student>();
        this.assignments=new ArrayList<Assignment>();
        this.trainers=new ArrayList<Trainer>();
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
    
    public void addStudent(Student student){
        students.add(student);
    }
    
    public void addTrainer(Trainer trainer)
    {
        trainers.add(trainer);
    }
    
    public void addAssignment(Assignment assignment){
        
        assignments.add(assignment);
    }
    
    public List<Student> getStudents(){
        
        return students;
    }
    
    public List<Trainer> getTrainers(){
        
        return trainers;
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
    
    public String toString(){
        
        return title+","+stream+","+type+","+getStartDate()+","+getEndDate();
    }
    
   
}
