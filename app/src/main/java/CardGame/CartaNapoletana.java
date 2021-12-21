package CardGame;

import CardGame.Interfacce.ICartaNapoletana;

public class CartaNapoletana<Napoletana> implements ICartaNapoletana<Napoletana> {

    public enum Seme {
        BASTONI,
        COPPE,
        DENARI,
        SPADE;
    }
        
    public Seme semeNapoletana;
    public int valoreNapoletana;



    public CartaNapoletana(Seme semeNapoletana, int valoreNapoletana) {
        this.semeNapoletana = semeNapoletana;
        this.valoreNapoletana = valoreNapoletana;
    }



    @Override
    public void setSemeNapoletana() {
         
    }



    @Override
    public void setValoreNapoletana() {
        // TODO Auto-generated method stub
        
    }
    
}

