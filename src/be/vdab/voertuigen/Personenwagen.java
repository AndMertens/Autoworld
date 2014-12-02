/*
 *personenwagen.java
 */
package be.vdab.voertuigen;
import be.vdab.util.mens.Mens;
import be.vdab.util.Datum;
import java.lang.IllegalArgumentException;
import java.awt.Color;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.util.mens.MensException;
import java.io.Serializable;
import java.util.List;
import java.util.Arrays;


/**
 *
 * @author Andy.Mertens
 */
public class Personenwagen extends Voertuig implements Comparable<Voertuig>{
    
    public static final int MAX_AANTAL_PLAATSEN = 8;
    
    private Color kleur;
    
      /**
     * @return the kleur
     */
    public Color getKleur() {
        return kleur;
    }

    /**
     * @param kleur the kleur to set
     */
    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }
        
    public Personenwagen(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Color kleur,Mens bestuurder,Mens...inzittenden){
        super(merk,datumEersteInGebruikname, aankoopprijs, aantalZitplaatsen, bestuurder,inzittenden);
        if(aantalZitplaatsen>this.getMAX_ZITPLAATSEN())
            throw new IllegalArgumentException("Aantal zitplaatsen (" + String.valueOf(aantalZitplaatsen) +") is groter dan maximaal aantal toegelaten (" +String.valueOf(this.getMAX_ZITPLAATSEN())+")" );
        this.kleur = kleur;
    }
    
    public Personenwagen(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Color kleur,Mens bestuurder){
        
        super(merk,datumEersteInGebruikname, aankoopprijs, aantalZitplaatsen, bestuurder);
        if(aantalZitplaatsen>this.getMAX_ZITPLAATSEN())
            throw new IllegalArgumentException("Aantal zitplaatsen (" + String.valueOf(aantalZitplaatsen) +") is groter dan maximaal aantal toegelaten (" +String.valueOf(this.getMAX_ZITPLAATSEN())+")" );
        this.kleur = kleur;
    }
    
    @Override public String toString(){
        StringBuilder tmpString = new StringBuilder(super.toString());
        tmpString.append(", Kleur(");
        tmpString.append(this.kleur.toString());
        tmpString.append(")");
        return tmpString.toString();
    }
    
    @Override public int hashCode(){
        return super.hashCode();
    }
    
    @Override public boolean equals(Object v){
        if(!(v instanceof Voertuig))
            return false;
        else{
            Voertuig ander = (Voertuig)v;
            return super.equals(ander); 
        }
    }
    
    @Override public int compareTo(Voertuig v){
            return super.compareTo(v);
    }
    
    @Override protected int getMAX_ZITPLAATSEN()
    {
        return Personenwagen.MAX_AANTAL_PLAATSEN;
    }
    
    @Override protected final Rijbewijs[] getToegestaneRijbewijzen(){
        return new Rijbewijs[]{Rijbewijs.B,Rijbewijs.BE};
    }
   
}
