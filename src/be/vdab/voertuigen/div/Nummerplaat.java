/*
* @Autor Frank
* Dit is een oefening.
 */

package be.vdab.voertuigen.div;

import be.vdab.util.BewaarException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

/**
 *
 * @author frank.roelants
 */

//added final on 24/11/2014
public final class  Nummerplaat implements Serializable,Comparable<Nummerplaat> {
    private final String plaat;
    //private final FileOutputStream fsNummerplaat=null;
    //private final File bestandNrplaat=null;
    private ObjectOutputStream outputBuffer=null;
    

    protected Nummerplaat(String plaat) {
        this.plaat = plaat;
    }
    
    public void bewaarNummerplaten(Collection<Nummerplaat> platen, String naamBestand)throws BewaarException{
        
        try {
            if (platen.isEmpty() || naamBestand.isEmpty() || naamBestand.equals("")) {
                if(platen.isEmpty()) throw new BewaarException("De lijst van nummerplaten bevat geen gegevens"); 
                if(!naamBestand.isEmpty() || !naamBestand.equals("")) throw new BewaarException("De naam van het bestand is leeg"); 
            }   
            else{   
               outputBuffer = new ObjectOutputStream(new FileOutputStream(new File(naamBestand)));
               for(Nummerplaat p:platen){
                   outputBuffer.writeObject(p);
               }
            }
        }
        catch(FileNotFoundException ex ){System.err.println(ex.getMessage());}
        catch(IOException ex){System.err.println(ex.getMessage());}
        catch(BewaarException ex) {System.err.println(ex.getMessage());}
        
        finally{
            try{if(outputBuffer!=null) outputBuffer=null;}
            catch(Exception ex){System.err.println(ex.getMessage());}
        }
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
