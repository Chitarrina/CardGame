package cardgame.libreria.giocatore;

import cardgame.libreria.model.ICarta;

public interface IGiocatore<K extends ICarta> {

    public String getNome();
}
