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
public enum Type {
    FullTime{
        @Override
                public String toString(){
                    return "Full Time Student"; 
                }
    },
    PartTime{
        @Override
                public String toString(){
                    return "Part Time Student"; 
                }
    }
}