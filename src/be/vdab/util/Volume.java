/*
 * Volume.java
 */
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author Andy.Mertens
 */
public class Volume implements Comparable<Volume> ,Serializable{
   
    public static final long serialVersionUID = 1l;
    
    private int hoogte;
    private int breedte;
    private int diepte;
    private Maat maat;
    
    //private static int FACTOR_M_IN_CM =100;
    //private static int FACTOR_M_IN_DM =10;
           
    public Volume(int hoogte, int breedte , int diepte, Maat maat){
       
        try{
        SetVolume(hoogte,breedte,diepte,maat);
        }
        catch(VolumeException ex){System.err.println(ex.getMessage());}
    }

    /**
     * @return the hoogte
     */
    public int getHoogte() {
        return hoogte;
    }

    /**
     * @return the breedte
     */
    public int getBreedte() {
        return breedte;
    }

    /**
     * @return the diepte
     */
    public int getDiepte() {
        return diepte;
    }

    /**
     * @return the maat
     */
    public Maat getMaat() {
        return maat;
    }
    
    public long getVolume(){
        return (long)this.getBreedte() * this.getHoogte() * this.getHoogte();
    }
    
    private void SetVolume(int hoogte, int breedte , int diepte, Maat maat)throws VolumeException{
         if(hoogte <0 || breedte <0 || diepte <0){ 
            if(hoogte<=0)
                throw new VolumeException("Hoogte moet groter zijn dan 0");
            if(breedte<=0)
                throw new VolumeException("Breedte moet groter zijn dan 0");
            if (diepte <=0)
                throw new VolumeException("Diepte moet groter zijn dan 0");
        }
        this.hoogte=hoogte;
        this.breedte=breedte;
        this.diepte=diepte;
        this.maat = maat;
    }
    
    @Override public String toString(){
       StringBuffer volume = new StringBuffer("");
       volume.append(String.valueOf(hoogte));
       volume.append("(h)x");
       volume.append(String.valueOf(breedte));
       volume.append("(b)x");
       volume.append(String.valueOf(diepte));
       volume.append("(d) ");
       volume.append(maat.toString());
       return volume.toString();
    }
    
    
    
    @Override public int hashCode(){
        return this.toString().hashCode();
    }
    
    @Override public boolean equals(Object v){
        if(!(v instanceof Volume))
            return false;
        else{
            Volume ander = (Volume)v;
            return (this.toString().equals(ander.toString()));
        }
     }
    
    @Override public int compareTo(Volume v){
        
        long thisVolumeInMeter;
        long anderVolumeInMeter;
        
        if (this.toString().equals(v.toString())) 
            return 0;
        //als maateenheid niet hetzelfde is moet alles naar 1 eenheid worden gezet om te vergelijken
        else { 
            if(this.maat.toString().equals(v.maat.toString())) 
                return this.getVolume()< v.getVolume()? -1:1;
            else {
                thisVolumeInMeter = this.getVolume() * this.getMaat().getValue();
                anderVolumeInMeter = v.getVolume() * v.getMaat().getValue();
                return thisVolumeInMeter < anderVolumeInMeter ? -1:1;
            }    
        }
    }
    
    
}
