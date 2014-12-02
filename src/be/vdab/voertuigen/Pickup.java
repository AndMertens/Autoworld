/*
 * Pickup.java
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Andy.mertens
 */
public class Pickup extends Personenwagen implements Laadbaar{
    
    //public static final long serialVersionUID = 1l;
    private Volume volume;
    
    public Pickup(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Color kleur,Volume volume,Mens bestuurder, Mens...inzittenden){
        super(merk,datumEersteInGebruikname, aankoopprijs, aantalZitplaatsen,kleur,bestuurder,inzittenden);
        this.volume = volume;
    }
    
    public Pickup(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Color kleur,Volume volume,Mens bestuurder){
        super(merk,datumEersteInGebruikname, aankoopprijs, aantalZitplaatsen,kleur,bestuurder);
        this.volume = volume;
    }
        
    @Override public Volume getLaadvolume(){
        return this.volume;
    }
    
    @Override public void setLaadvolume(Volume vol){
        this.volume = vol;
    }
    
    @Override public String toString(){
        StringBuilder tmpString = new StringBuilder(super.toString());
        tmpString.append(", LaadVol(");
        tmpString.append(this.volume.toString());
        return tmpString.toString();
    }
    
    @Override public int hashCode(){
        return this.toString().hashCode();
    }
    
    @Override public boolean equals(Object p){
        if(!(p instanceof Pickup))
            return false;
        else{
            Pickup ander = (Pickup)p;
            return super.equals(ander);
        }
    }
}
