/*
 * Voertuig.java
 */
package be.vdab.voertuigen;

import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import be.vdab.util.mens.Mens;
import java.util.List;
import java.util.ArrayList;
import be.vdab.util.Datum;
import java.io.Serializable;
import java.util.Comparator;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;


/**
 *
 * @author Andy.Mertens
 */
public abstract class Voertuig implements Serializable,Comparable<Voertuig>{
    
    public static final long serialVersionUID = 1l;
    
    public static Comparator<Voertuig> getMerkComparator(){
       
       return new Comparator<Voertuig>() {
            @Override public int compare(Voertuig v1, Voertuig v2){
                return v1.getMerk().compareTo(v2.getMerk());
            }
        };
    }
    
    public static Comparator<Voertuig> getAankoopprijsComparator(){
       
       return new Comparator<Voertuig>() {
            @Override public int compare(Voertuig v1, Voertuig v2){
                return v1.getAankoopprijs()==v2.getAankoopprijs()? -1:v2.getAankoopprijs()-v1.getAankoopprijs();
            }
        };
    }
        
    private final Nummerplaat nummerplaat = DIV.getInstance().getNummerplaat();

    private String merk;
    private Datum datumEersteInGebruikname;
    private int aankoopprijs;
    private int zitplaatsen;
    private List<Mens> inzittenden = new ArrayList<Mens>(); 
    
    
    //CLASS CONSTRUCTORS
    public Voertuig(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Mens bestuurder, Mens...inzittenden){
        this.merk = merk;
        this.datumEersteInGebruikname = datumEersteInGebruikname;
        this.aankoopprijs = aankoopprijs;
        this.zitplaatsen = aantalZitplaatsen;
        this.inzittenden.add(0,bestuurder);
        try{
            this.setIngezetenen(inzittenden);
        }
        catch(MensException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public Voertuig(String merk,Datum datumEersteInGebruikname,int aankoopprijs,int aantalZitplaatsen,Mens bestuurder){
        this.merk = merk;
        this.datumEersteInGebruikname = datumEersteInGebruikname;
        this.aankoopprijs = aankoopprijs;
        this.zitplaatsen = aantalZitplaatsen;
        this.inzittenden.add(0,bestuurder);
    }
        
    
    //CLASS PROPERTIES
    
    /**
     * @return the nummerplaat
     */
    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }
    
    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * @return the datumEersteInGebruikname
     */
    public Datum getDatumEersteIngebruikname() {
        return datumEersteInGebruikname;
    }

    /**
     * @param datumEersteInGebruikname the datumEersteInGebruikname to set
     */
    public void setDatumEersteIngebruikname(Datum datumEersteInGebruikname) {
        this.datumEersteInGebruikname = datumEersteInGebruikname;
    }

    /**
     * @return the aankoopprijs
     */
    public int getAankoopprijs() {
        return aankoopprijs;
    }

    /**
     * @param aankoopprijs the aankoopprijs to set
     */
    public void setAankoopprijs(int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    /**
     * @return the zitplaatsen
     */
    public int getZitplaatsen() {
        return zitplaatsen;
    }

    /**
     * @param zitplaatsen the zitplaatsen to set
     */
    public void setZitplaatsen(int zitplaatsen){
        this.zitplaatsen = zitplaatsen;
    }
       
    /**
     * @return the inzittenden
     */
    public List<Mens> getIngezetenen() {
        return inzittenden;
    }

    /**
     * @param inzittenden the inzittenden to set
     * @throws be.vdab.util.mens.MensException
     */
    protected void setIngezetenen(Mens[] inzittenden) throws MensException {
        if(inzittenden.length > this.getZitplaatsen())
                throw new MensException("Aantal inzittenden ( " + inzittenden.length + ") overschrijd aantal zitplaatsen " + this.getZitplaatsen());
        else
            for(Mens i:inzittenden){ this.inzittenden.add(this.inzittenden.size(),i); }
    }
    
    protected Mens getBestuurder(){
        return this.getIngezetenen().get(0);
    }
    
    protected void setBestuurder(Mens bestuurder){
        if(this.inzittenden.size()<this.getZitplaatsen())
            this.inzittenden.add(0, bestuurder);
    }
    
    protected List<Mens> getIngezeteneExclusiefBestuurder(){
        return inzittenden.subList(1, this.inzittenden.size());
    }
    
    protected void addIngezetene(Mens passagier){
        if(this.inzittenden.size()<this.getZitplaatsen())
            this.inzittenden.add(passagier);
    }
    
    protected boolean isIngezetene(Mens passagier){
        return this.inzittenden.contains(passagier);
    }
    
    // ABSTRACT FUNCTIONS FOR DERIVED CLASSES
    protected abstract Rijbewijs[] getToegestaneRijbewijzen();
    protected abstract int getMAX_ZITPLAATSEN();
    
    
    // OVERRIDE FUNCTIONS FOR OBJECTS
    
    @Override public String toString(){
        StringBuilder tmpString = new StringBuilder("");
        tmpString.append("Merk(");
        tmpString.append(this.merk);
        tmpString.append("), In Gebruik(");
        tmpString.append(this.datumEersteInGebruikname.toString());
        tmpString.append("), Prijs(");
        tmpString.append(String.valueOf(this.aankoopprijs));
        tmpString.append("), Zitplaatsen(");
        tmpString.append(String.valueOf(this.zitplaatsen));
        tmpString.append(")");
        return tmpString.toString();          
    }
    
    @Override public boolean equals(Object o){
        if(o instanceof Voertuig)
            return false;
        else{
            Voertuig eenAnder = (Voertuig)o;
            return this.getNummerplaat().toString().equals(eenAnder.getNummerplaat().toString());
        }
    }
    
    @Override public int hashCode(){
        return this.toString().hashCode();
    }
    
    @Override public int compareTo(Voertuig v){
        if (this.equals(v))
            return 0;
        else
            return this.getNummerplaat().compareTo(v.getNummerplaat());
    }
    
  }
