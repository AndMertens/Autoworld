/*
 * Boekentas.java
 */
package be.vdab.schoolgerief;

import be.vdab.util.Volume;
import be.vdab.util.Laadbaar;
import java.io.Serializable;

/**
 *
 * @author Andy.Mertens
 */
public class Boekentas implements Serializable,Laadbaar {
    
    private String kleur;
    private Volume volume;
    
    public Boekentas (String kleur, Volume volume) throws IllegalArgumentException{
        if(volume ==null)
            throw new IllegalArgumentException("Ongeldig volume object (null) in new boekentas");
        if(kleur ==null || kleur.isEmpty())
            throw new IllegalArgumentException("Ongeldige kleur (null of \"\") in new boekentas");
            
        this.kleur = kleur;
        this.volume = volume;
        }
        
    /**
     * @return the kleur
     */
    public String getKleur() {
        return kleur;
    }

    
    @Override public Volume getLaadvolume() {
        return this.volume;
    }
    
    @Override public void setLaadvolume(Volume volume)throws IllegalArgumentException {
        if (volume == null)
            throw new IllegalArgumentException("Ongeldig volume object (null) in method setLaadvolume");
        this.volume = volume;
    }

    /**
     * @param kleur the kleur to set
     */
    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
    
    @Override public String toString(){
        StringBuffer tmpTostring = new StringBuffer("");
        tmpTostring.append(this.kleur);
        tmpTostring.append(" - ");
        tmpTostring.append(this.volume.toString());
        return tmpTostring.toString();
    }
    
    @Override public int hashCode(){
        return this.toString().hashCode();
    }
    
    @Override public boolean equals(Object tas){
        if(!(tas instanceof Boekentas))
            return false;
        else{
            Boekentas ander = (Boekentas)tas;
            return this.toString().equals(ander);
        }    
    }
    
    
}
