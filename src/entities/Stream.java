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
public enum Stream {
    JAVA{
        @Override
                public String toString(){
                    return "JAVA Stream"; 
                }
        
    },
    CSHARP{
        @Override
                public String toString(){
                    return "C# Stream"; 
                }
    }
}
