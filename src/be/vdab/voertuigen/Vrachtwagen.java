/*
 * Vrachtwagen.java
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.io.Serializable;



/**
 *
 * @author Andy.mertens
 */
public class Vrachtwagen extends Voertuig implements Laadbaar{
     //public static final long serialVersionUID = 1l;
     private Volume volume;
     private int maxToegelatenMassa;
     private int aantalAssen;
     
     public static final int MAX_AANTAL_PLAATSEN = 3;
     
     
    /**
     * @return the volume
     */
    public Volume getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    /**
     * @return the maxToegelatenMassa
     */
    public int getMaximaalToegelatenMassa() {
        return maxToegelatenMassa;
    }

    /**
     * @param maxToegelatenMassa the maxToegelatenMassa to set
     */
    public void setMaximaalToegelatenMassa(int maxToegelatenMassa) {
        this.maxToegelatenMassa = maxToegelatenMassa;
    }

    /**
     * @return the aantalAssen
     */
    public int getAantalAssen() {
        return aantalAssen;
    }

    /**
     * @param aantalAssen the aantalAssen to set
     */
    public void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }
    
    public Vrachtwagen(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Volume volume,int maxMassa, int aantalAssen,Mens bestuurder,Mens...inzittenden){
        super(merk,datumEersteInGebruikname, aankoopprijs, aantalZitplaatsen,bestuurder,inzittenden);
        this.volume= volume;
        this.maxToegelatenMassa = maxMassa;
        this.aantalAssen = aantalAssen;
    }
    
    public Vrachtwagen(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Volume volume,int maxMassa, int aantalAssen,Mens bestuurder){
        super(merk,datumEersteInGebruikname, aankoopprijs, aantalZitplaatsen,bestuurder);
        this.volume= volume;
        this.maxToegelatenMassa = maxMassa;
        this.aantalAssen = aantalAssen;
    }
        
    @Override public Volume getLaadvolume(){
        return this.getVolume();
    }
    
    @Override public void setLaadvolume(Volume vol){
        this.setVolume(vol);
    }
    
    @Override public String toString(){
        StringBuilder tmpString = new StringBuilder(super.toString());
         tmpString.append("), MTM(");
        tmpString.append(this.maxToegelatenMassa);
        tmpString.append("), Aantal Assen(");
        tmpString.append(this.aantalAssen);
        tmpString.append(", LaadVol(");
        tmpString.append(this.volume.toString());
       
        tmpString.append(")");
        
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
       
    @Override protected int getMAX_ZITPLAATSEN()
    {
        return Vrachtwagen.MAX_AANTAL_PLAATSEN;
    }
    @Override protected final Rijbewijs[] getToegestaneRijbewijzen(){
        return new Rijbewijs[]{Rijbewijs.C,Rijbewijs.CE};
    }
        
}
