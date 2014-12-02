/*
* @Autor Frank
* Dit is een oefening.
 */

package be.vdab.voertuigen.div;

import java.io.Serializable;


/**
 *
 * @author frank.roelants
 */

//added final on 24/11/2014
public final class  Nummerplaat implements Serializable,Comparable<Nummerplaat> {
    private final String plaat;
    public static final long serialVersionUID = 1l;
    
    protected Nummerplaat(String plaat) {
        this.plaat = plaat;
    }
    
    protected String getNummerplaat(){
        return this.plaat;
    }
    
    @Override
    public int hashCode() {
        return plaat.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Nummerplaat) &&
               ((Nummerplaat)obj).plaat.equals(this.plaat);
    }

    @Override
    public String toString() {
        return plaat.toString();
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return plaat.compareTo(o.plaat);
    }
    
}
