/*
 * Main.java
 */
package be.vdab.voertuigen.main;

import be.vdab.util.Datum;
import be.vdab.util.mens.*;
import be.vdab.util.mens.Rijbewijs.*;
import java.util.Set;
import java.util.TreeSet;
import be.vdab.voertuigen.*;
import java.awt.Color;
import be.vdab.util.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author Andy.mertens
 */
public class Main {
     
    private static final Rijbewijs A = Rijbewijs.A;  
    private static final Rijbewijs B = Rijbewijs.B;
    private static final Rijbewijs C = Rijbewijs.C;
    
    private static final Mens BESTUURDER_A = new Mens("Inge",A);
    private static final Mens BESTUURDER_C = new Mens("Ingrid",A,B,C);
    private static final Mens BESTUURDER_B = new Mens("Andy",A,B);
        
    private static final Mens PASSAGIER_1 = new Mens("Dania");
    private static final Mens PASSAGIER_2 = new Mens("Kyna");
    private static final Mens PASSAGIER_3 = new Mens("Nancy",A,B);
    
    public static void main(String[] args){
        
        Set<Voertuig> Voertuigen1 = new TreeSet<Voertuig>();
        Set<Voertuig> Voertuigen2 = new TreeSet<Voertuig>(Voertuig.getAankoopprijsComparator());
        Set<Voertuig> Voertuigen3 = new TreeSet<Voertuig>(Voertuig.getMerkComparator());
        genereerVoertuigen(Voertuigen1);
        System.out.println("Lijst van voertuigen in natuurlijke orde");
        System.out.println("----------------------------------------");
        drukLijstVoertuigen(Voertuigen1);
        System.out.println();
        System.out.println("Lijst van voertuigen per aankoopprijs");
        System.out.println("-------------------------------------");
        Voertuigen2.addAll(Voertuigen1);
        drukLijstVoertuigen(Voertuigen2);
        System.out.println();
        System.out.println("Lijst van voertuigen per merk");
        System.out.println("-----------------------------");
        Voertuigen3.addAll(Voertuigen1);
        drukLijstVoertuigen(Voertuigen3);
        schrijfNaarBestandVoertuigen(Voertuigen3);
        System.out.println();
        System.out.println("Lijst van voertuigen in bestand wagenpark.ser (natuurlijke orde)");
        System.out.println("----------------------------------------------------------------");
        Set<Voertuig> lijst = leesVanBestandVoertuigen();
        drukLijstVoertuigen(lijst);
        System.out.println();
        
    }
    
    private static void genereerVoertuigen(Set<Voertuig> voertuigen){
        voertuigen.add(new Personenwagen("VW",new Datum(11,Datum.Maand.JULI.ordinal(),2011),12500,5,Color.GRAY,BESTUURDER_B,PASSAGIER_1,PASSAGIER_2));
        voertuigen.add(new Personenwagen("VW",new Datum(07,Datum.Maand.JANUARI.ordinal(),1994),25000,6,Color.BLUE,BESTUURDER_C));
        voertuigen.add(new Personenwagen("MERCEDES",new Datum(11,Datum.Maand.JULI.ordinal(),2011),43000,5,Color.GRAY,BESTUURDER_B,PASSAGIER_1,PASSAGIER_2));
        voertuigen.add(new Personenwagen("FORD",new Datum(07,Datum.Maand.JANUARI.ordinal(),2011),25000,6,Color.BLUE,BESTUURDER_C));
        voertuigen.add(new Vrachtwagen("MAN",new Datum(11,Datum.Maand.JULI.ordinal(),2011),35000,5,new Volume(2500,2000,8000,Maat.centimeter),15000,6,BESTUURDER_C,PASSAGIER_1,PASSAGIER_2));
        voertuigen.add(new Vrachtwagen("VOLVO",new Datum(11,Datum.Maand.FEBRUARI.ordinal(),2005),12500,5,new Volume(2250,1800,3500,Maat.centimeter),15000,6,BESTUURDER_C,PASSAGIER_1));
        voertuigen.add(new Pickup("DODGE",new Datum(11,Datum.Maand.JULI.ordinal(),2011),35000,5,Color.BLUE,new Volume(2500,2000,8000,Maat.centimeter),BESTUURDER_B,PASSAGIER_1,PASSAGIER_2));
        voertuigen.add(new Pickup("ROVER",new Datum(11,Datum.Maand.FEBRUARI.ordinal(),2005),12500,5,Color.BLUE,new Volume(2250,1800,3500,Maat.centimeter),BESTUURDER_B,PASSAGIER_1));
    }
    
    private static void drukLijstVoertuigen(Set<Voertuig>lijstVoertuigen){
        for(Voertuig v: lijstVoertuigen){
            System.out.println(v.toString());
        }
    }
    
    private static void schrijfNaarBestandVoertuigen(Set<Voertuig> lijst){
        ObjectOutputStream oosWagenpark=null;
        try{
            oosWagenpark= new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\andy.mertens\\Documents\\wagenpark.ser")));
            for (Voertuig v : lijst) {
                oosWagenpark.writeObject(v);
            }   
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            try{
                if(oosWagenpark!=null) {
                    oosWagenpark.flush();
                    oosWagenpark.close();
                    oosWagenpark = null;
                }
            }
            catch(Exception ex){System.err.println(ex.getMessage());}
            }
        }
    
    private static Set<Voertuig>leesVanBestandVoertuigen(){
        ObjectInputStream oosWagenpark=null;
        Set<Voertuig> lijst = new TreeSet<Voertuig>();
        try{
            oosWagenpark= new ObjectInputStream(new FileInputStream(new File("C:\\Users\\andy.mertens\\Documents\\wagenpark.ser")));
            while(true){
            lijst.add((Voertuig)oosWagenpark.readObject());
            }
           
        }
        catch(EOFException ex ){
            
        }
        catch(IOException | ClassNotFoundException ex ){
            System.err.println(ex.getMessage());
        }
        finally{
           
            try{
                if(oosWagenpark!=null){
                    oosWagenpark.close();
                    oosWagenpark = null;
                }
            }
            catch(Exception ex){System.err.println(ex.getMessage());}
            }
            return lijst;
        }
}
    