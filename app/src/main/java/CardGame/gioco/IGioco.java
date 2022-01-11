package cardgame.gioco;

import cardgame.carta.ICarta;
import cardgame.enumerazione.StatoGioco;
import cardgame.giocatore.IGiocatore;

public interface IGioco<C extends ICarta> {

    StatoGioco getStatoGioco();

    void faiMossa(IGiocatore<C> giocatore, C carta);
}
