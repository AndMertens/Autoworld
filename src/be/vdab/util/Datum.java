/*
 * Datum.java
 */
package be.vdab.util;
import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Andy.mertens
 */
public class Datum implements Serializable, Comparable<Datum>{
    
    public static final long serialVersionUID = 1l;
    
    public enum Maand {JANUARI, FEBRUARI, MAART, APRIL, MEI, JUNI, JULI, AUGUSTUS, SEPTEMER, OKTOBER, NOVEMBER, DECEMBER}
    
    //constanten voor bepalen van minimum en maximum datum bereik
    private final int MIN_JAARTAL=1583;
    private final int MAX_JAARTAL=4099;
    private final char DATUM_SEPARATOR= '/';
    private final int EERSTE_DAG_IN_MAAND  = 1;
    private final int LAATSTE_DAG_IN_MAAND = 31;
    
    private int dag;
    private int maand;
    private int jaar;
    
   public Datum(int dag, int maand, int jaar){
        try{
        setDatum(dag,maand,jaar);
        }
        catch(DatumException ex){System.err.println(ex.getMessage());}
    }

    /**
     * @return the dag
     */
    public int getDag() {
        return dag;
    }
    
    private final void setDatum(int dag, int maand, int jaar)throws DatumException{
        if( (jaar<MIN_JAARTAL || (jaar==MIN_JAARTAL && dag <=EERSTE_DAG_IN_MAAND && maand == Datum.Maand.JANUARI.ordinal())) ||
            (jaar>MAX_JAARTAL || (jaar==MAX_JAARTAL && dag >=LAATSTE_DAG_IN_MAAND && maand ==Datum.Maand.DECEMBER.ordinal()))
          )
          throw new DatumException("Ongeldige invoerdatum : " + String.valueOf(dag) +  DATUM_SEPARATOR + String.valueOf(maand) + DATUM_SEPARATOR + String.valueOf(jaar));
        else
        {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        }
    }
    
    /**
     * @return the maand
     */
    public int getMaand() {
        return maand;
    }

    /**
     * @return the jaar
     */
    public int getJaar() {
        return jaar;
    }
    
    @Override public String toString(){
        return (String.valueOf(dag) +  DATUM_SEPARATOR + String.valueOf(maand) + DATUM_SEPARATOR + String.valueOf(jaar));
    }
    
    @Override public boolean equals(Object o){
        if(!( o instanceof Datum))
            return false;
        else{
            Datum andereDatum = (Datum)o;    
            return this.toString().equals(andereDatum.toString());
        }
    }
        
    @Override public int hashCode(){
        return Integer.parseInt(String.valueOf(this.dag) + String.valueOf( this.maand) +String.valueOf( this.jaar));
    }
    
    @Override public int compareTo(Datum d){
        if(Integer.parseInt(this.toString())== Integer.parseInt(d.toString()))
            return 0;
        else
            return Integer.parseInt(this.toString())> Integer.parseInt(d.toString()) ? 1 :-1 ; 
    }
        
}
