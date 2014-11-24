/*
 * DIV.java
 */
package be.vdab.voertuigen.div;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Andy.mertens
 */
public class DIV {

    private final static String ALPHA_DEEL_PLAAT="AAA";
    private final static int NUMERIEK_MAX_PLAAT = 999;
    private final static DIV instance= new DIV() ;
    private final static SortedSet<Nummerplaat> platen = new TreeSet<Nummerplaat>();
    
    protected DIV(){}
    
    public static DIV getInstance(){
       return instance;
    }
    
    public Nummerplaat geefNummerplaat(){
        return (genereerNummerPlaat()); 
    }
    
    private static Nummerplaat genereerNummerPlaat(){
        
        int volgendNummer;
        Nummerplaat nieuwePlaat;
    
        //bepaal volgnummer (numeriek deel 3 cijfers en bij 999 terug naar 1)
        if(platen.isEmpty() || platen.size()==NUMERIEK_MAX_PLAAT) volgendNummer = 1;
        else volgendNummer = platen.size()+1;
        nieuwePlaat = new Nummerplaat(ALPHA_DEEL_PLAAT + String.format("%03d", volgendNummer));
        platen.add(nieuwePlaat);
        return nieuwePlaat;
    }
}
