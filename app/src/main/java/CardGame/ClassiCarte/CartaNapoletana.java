package CardGame.ClassiCarte;

import CardGame.InterfacceCarte.ICartaNapoletana;

public class CartaNapoletana<Napoletana> implements ICartaNapoletana<Napoletana> {

    private Seme semeNapoletana;
    private int valoreNapoletana;

    public CartaNapoletana(Seme semeNapoletana, int valoreNapoletana) {
        this.semeNapoletana = semeNapoletana;
        this.valoreNapoletana = valoreNapoletana;
    }

    


    @Override
    public void setSemeNapoletana() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValoreNapoletana() {
        // TODO Auto-generated method stub
        
    }

}

