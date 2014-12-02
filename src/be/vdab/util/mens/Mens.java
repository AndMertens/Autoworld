/*
 *mens.java
 */
package be.vdab.util.mens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Andy.mertens
 */
public class Mens implements Comparable<Mens>,Serializable {
    
    public static final long serialVersionUID = 1l;
    
    private String naam;
    private List<Rijbewijs> rijbewijzen=new ArrayList<Rijbewijs>(); 
    
    public Mens(String naam, Rijbewijs...rijbewijzen){
        this.naam = naam;
        this.rijbewijzen.addAll(Arrays.asList(rijbewijzen));
    }
    
    public Mens(String naam){
        this.naam = naam;
    }
    
    public String getNaam(){
        return this.naam;
    }
    
    public Object[] getRijbewijs(){
        return rijbewijzen.toArray();
    }   
    
    @Override public String toString(){
       StringBuffer sbMens= new StringBuffer("");
       sbMens.append(this.naam);
       sbMens.append("(");
       if(!(this.rijbewijzen.isEmpty())) {
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
        if (!(m instanceof Mens || m==null))
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
        if(this.getNaam().equals(m.getNaam()))
            return 0;
        else
            return this.getNaam().compareTo(m.getNaam());
    }
    
    
}