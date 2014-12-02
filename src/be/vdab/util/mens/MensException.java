/*
 * MensException.java
 */
package be.vdab.util.mens;

/**
 *
 * @author Andy.mertens
 */
public class MensException extends Exception{
    
    public MensException(){};
    public MensException(String message){super(message);}
    public MensException(String message, Throwable cause){super(message,cause);};
    public MensException(Throwable cause){super(cause);};
}
