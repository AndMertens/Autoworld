/*
 *Rijbewijs.java
 */
package be.vdab.util.mens;

/**
 *
 * @author Andy.mertens
 */
public enum Rijbewijs{
   
        A("A"){@Override public String toString(){return "A";}},
        B("B"){@Override public String toString(){return "B";}},
        BE("BE"){@Override public String toString(){return "B+E";}},
        C("C"){@Override public String toString(){return "C";}},
        CE("CE"){@Override public String toString(){return "C+E";}},
        D("D"){@Override public String toString(){return "D";}},
        DE("DE"){@Override public String toString(){return "D+E";}},
        F("E"){@Override public String toString(){return "E";}},
        FE("FE"){@Override public String toString(){return "E+E";}},
        G("F"){@Override public String toString(){return "F";}},
        GE("GE"){@Override public String toString(){return "F+E";}};
         
        private final String naam;

        Rijbewijs(String naam) {
            this.naam = naam;
        }
        
        
        
        
}
    
        
    
 