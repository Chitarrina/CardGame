package cardgame.giocoPiripicchio.model;

import cardgame.libreria.model.CartaConSeme;

public final class CartaNapoletana extends CartaConSeme<SemiCarteNapoletane> {

    public CartaNapoletana(int valore, SemiCarteNapoletane seme) {
        super(valore, seme);
    }

    
    /** 
     * Overriding del metodo toString della classe Object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "CartaNapoletana [valore=" + (this.getValue() + 1) + ", seme=" + this.getSeed() + "]";
    }
}
