package cardgame.giocatore;

import cardgame.carta.ICarta;

public interface IGiocatore<C extends ICarta> {

    public String getNome();

    public C getMossa();
}
