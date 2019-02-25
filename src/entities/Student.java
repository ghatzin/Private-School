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
public class Student {
    
    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private double tuitionFees;
    
    
    public Student(){
        
    }
    
    public Student(String firstName,String lastName,int dateOfBirth,double tuitionFees)
    {
       this.firstName=firstName;
       this.lastName=lastName;
       this.dateOfBirth=dateOfBirth;
       this.tuitionFees=tuitionFees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
    
    public String toString(){
        
        return firstName+" "+lastName+" "+dateOfBirth+" "+tuitionFees;
    }
    
}
