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
public class Nummerplaat implements Serializable,Comparable<Nummerplaat> {
    private String plaat;

    protected Nummerplaat(String plaat) {
        this.plaat = plaat;
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
