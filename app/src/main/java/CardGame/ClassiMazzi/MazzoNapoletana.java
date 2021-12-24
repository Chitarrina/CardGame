package CardGame.ClassiMazzi;
import java.util.HashSet;

import CardGame.InterfacceMazzi.IMazzoNapoletana;

public class MazzoNapoletana<Napoletana> implements IMazzoNapoletana<Napoletana> {

    private int numeroCarte = 40;

    private HashSet<Napoletana> mazzoNaple;




    /* Creata la collection, come aggiungiamo gli elementi al suo interno, dato che le carte napoletane sono una combinazione
       di semi e valori? Con l'utilizzo di una Map/HashMap? */    

       @Override
       public void shuffleMazzo() {
           // TODO Auto-generated method stub 
       }
}