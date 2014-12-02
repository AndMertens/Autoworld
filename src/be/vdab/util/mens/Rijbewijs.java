/*
 *Rijbewijs.java
 */
package be.vdab.util.mens;

/**
 *
 * @author Andy.mertens
 */
public enum Rijbewijs {
   
    A,
    B,
    BE,
    C,
    CE,
    D,
    DE;

   @Override public String toString(){

       String naamRijbewijs = super.toString();
       if(naamRijbewijs.length()>1)
            return naamRijbewijs.charAt(0) + "+" + naamRijbewijs.charAt(1);
       else
            return naamRijbewijs;
    }   
}
    
        
    
 