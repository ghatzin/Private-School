/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author George
 */
public class Assignment {
    
    private String title;
    private String description;
    private LocalDate submissionDate;
    private LocalTime submissionTime;
    private double oralMark;
    private double totalMark;
    
    
    public Assignment(){
        
    }
    
    
    public Assignment(String title,String description,String submissionDate,String submissionTime,double oralMark,double totalMark)
    {
        this.title=title;
        this.description=description;
        this.submissionDate=LocalDate.parse(submissionDate,DateTimeFormatter.ISO_LOCAL_DATE);
        this.submissionTime=LocalTime.parse(submissionTime,DateTimeFormatter.ISO_TIME);
        this.oralMark=oralMark;
        this.totalMark=totalMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDateTime) {
        this.submissionDate = submissionDateTime;
    }

    public LocalTime setSubmissionTime(LocalTime submissionTime){
        return submissionTime;
    }
    
    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(double oralMark) {
        this.oralMark = oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }
    
    public LocalDateTime getSubmissionDateTime(){
        
        return submissionDate.atTime(submissionTime);
    }
    
    public String getSubmissionDateTimeAsString(){
        
        return submissionDate.getDayOfMonth()+" "+
               submissionDate.getMonth()+" "+
               submissionDate.getYear()+" "+
               submissionTime.getHour()+" "+
               submissionTime.getMinute();
    }
    
}
