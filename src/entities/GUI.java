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

import java.util.*;

public class GUI 
{
    
    private static int userChoise=0;
    
    public static void displayInitialMenu()
    {
        
        System.out.println("            1.Enter Data            ");
        System.out.println("            2.Use Synthetic Data    ");
    }
    
    
    public static void enterDataMenu()
    {
        System.out.println("            1.Add Course                        ");
        System.out.println("            2.Add Student                       ");
        System.out.println("            3.Add Trainer                       ");
        System.out.println("            4.Add Assignment                    ");
        System.out.println("            5.Assign Student to Course          ");
        System.out.println("            6.Assign Assignment to Course       ");
        System.out.println("            7.Assign Trainer to Course          ");
        
    }
    
    public static void displayReports()
    {
        System.out.println("            1.Diplay All Courses                 ");
        System.out.println("            2.Display All Students             ");
        System.out.println("            3.Display All Trainers               ");
        System.out.println("            4.Display Students Per Course        ");
        System.out.println("            5.Display Trainers Per Course        ");
        System.out.println("            6.Display Assignments Per Course     ");
        System.out.println("            7.Display Assignments should be submitted according to date");
        System.out.println("            8.Display Students Who have Enrolled to more than one course");
        
    }
    
    
    public static void clearConsole()
    {
        
        for (int i=0;i<80;i++)
            System.out.println();
    }
    
    
    public static boolean checkIFUserInputIsNumber(Scanner scannerInput)
    {
        if (scannerInput.hasNextInt())
            return true;
        else
            return false;
    }
    
    
    public static void getUserChoise(Scanner scannerInput,int startMenuItem,int lastMenuItem)
    {
        while(!(scannerInput.hasNextInt()))
        {
            System.out.println("You should Give a number between "+startMenuItem+" "+lastMenuItem);
            scannerInput.next();
        }
                
         userChoise=scannerInput.nextInt();
    }
    
    public static boolean checkIFNumberIsCorrectChoice(int initialMenuItem,int lastMenuItem)
    {
        if (userChoise>=initialMenuItem && userChoise<=lastMenuItem)
            return true;
        else
            return false;
    }
    
    
    public static int getChoiseOfUSer()
    {
        return userChoise;
    }
}
