package cardgame.carta;

public abstract class Carta implements ICarta {

    private int valore;

    Carta(int valore) {
        this.valore = valore;
    }

    public int getValoreCarta() {
        return this.valore;
    }

    @Override
    public String toString() {
        return "Carta [valore=" + valore + "]";
    };
}
