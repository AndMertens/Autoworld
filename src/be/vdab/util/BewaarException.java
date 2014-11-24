/*
 * BewaarException.java
 */
package be.vdab.util;

/**
 *
 * @author Andy.mertens
 */
public class BewaarException extends Exception{
    
    public BewaarException(){}
    
    public BewaarException(Throwable cause){
        super(cause);
    }
    
    public BewaarException(String message, Throwable cause){
        super(message,cause);
    }
    
    public BewaarException(String message)
    {
        super (message);
    }
}
