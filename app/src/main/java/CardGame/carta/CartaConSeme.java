package cardgame.carta;

public abstract class CartaConSeme<S extends Enum<S>> extends Carta implements ICartaConSeme<S> {

    private S seme;

    CartaConSeme(int valore, S seme) {
        super(valore);
        this.seme = seme;
    }

    @Override
    public S getSemeCarta() {
        return this.seme;
    }

    @Override
    public String toString() {
        return "CartaConSeme [valore=" + this.getValoreCarta() + ", seme=" + seme + "]";
    }
}
