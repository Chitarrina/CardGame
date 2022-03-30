package cardgame.libreria.model;

import cardgame.libreria.exception.CartaException;

public interface IMazzo<TCarta extends ICarta> {

    public int getNumActualCards();
    public int getNumTotalCards();

    public TCarta draw() throws CartaException;
    public void shuffle();

    public TCarta showCard(int index) throws CartaException;
    public TCarta pickCard(int index) throws CartaException;
}
