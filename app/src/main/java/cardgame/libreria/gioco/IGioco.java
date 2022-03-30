package cardgame.libreria.gioco;

import cardgame.libreria.exception.CartaException;

public interface IGioco {

    public void gioca() throws CartaException;
}