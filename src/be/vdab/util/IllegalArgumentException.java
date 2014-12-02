/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author Andy.Mertens
 */
public class IllegalArgumentException extends Exception{
    
    public IllegalArgumentException(){}
    
    public IllegalArgumentException(String message){
        super(message);
    }
    
    public IllegalArgumentException(String message, Throwable cause){
        super(message, cause);
    }
    
    public IllegalArgumentException(Throwable cause){
        super(cause);
    }
}
