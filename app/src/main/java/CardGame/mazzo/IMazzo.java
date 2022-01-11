package cardgame.mazzo;

import cardgame.carta.ICarta;

public interface IMazzo<T extends ICarta> {

    public int getCarteTotali();

    public int getCarteRimanenti();

    public T pesca();

    public void shuffle();
}
