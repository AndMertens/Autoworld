/*
 *mens.java
 */
package be.vdab.util.mens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andy.mertens
 */
public class Mens implements Comparable<Mens> {
    
    private String naam;
    private Rijbewijs [] rijbewijzen; 
    
    public Mens(String naam, Rijbewijs...rijbewijzen){
        this.naam = naam;
        this.rijbewijzen = rijbewijzen;
    }
    
    @Override public String toString(){
       StringBuffer sbMens= new StringBuffer("");
       sbMens.append(this.naam);
       sbMens.append("(");
       if(!(this.rijbewijzen!=null && this.rijbewijzen.length>=1)) {
           for(Rijbewijs x:rijbewijzen){
                sbMens.append(x.toString());
                sbMens.append(", ");
           }
           sbMens.delete(sbMens.length()-1, sbMens.length());
        }
       sbMens.append(")");
       return sbMens.toString();
    }
    
    
    @Override public boolean equals(Object m){
        if (!(m instanceof Mens))
            return false;
        else{
            Mens ander = (Mens)m;
            return this.toString().equals(ander.toString());
        }
    }

    @Override public int hashCode(){
        return this.toString().hashCode();
    }
    
    @Override public int compareTo(Mens m){
        
    }
    
    
}