package cardgame.carta;

import cardgame.seme.SemiCarteNapoletane;

public final class CartaNapoletana extends CartaConSeme<SemiCarteNapoletane> {

    public CartaNapoletana(int valore, SemiCarteNapoletane seme) {
        super(valore, seme);
    }

    @Override
    public String toString() {
        return "CartaNapoletana [valore=" + this.getValoreCarta() + ", seme=" + this.getValoreCarta() + "]";
    }
}
