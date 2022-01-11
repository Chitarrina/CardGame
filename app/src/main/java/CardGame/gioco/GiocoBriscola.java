package cardgame.gioco;

import java.util.Collection;

import cardgame.carta.CartaNapoletana;
import cardgame.enumerazione.StatoGioco;
import cardgame.giocatore.IGiocatore;
import cardgame.mazzo.IMazzo;

public class GiocoBriscola implements IGioco<CartaNapoletana> {

    private StatoGioco statoGioco;
    private IMazzo<CartaNapoletana> mazzo;
    private Collection<IGiocatore<CartaNapoletana>> giocatori;

    public GiocoBriscola(IMazzo<CartaNapoletana> mazzo, Collection<IGiocatore<CartaNapoletana>> giocatori) {
        this.statoGioco = StatoGioco.DA_INIZIARE;
        this.mazzo = mazzo;
        this.giocatori = giocatori;
    }

    public StatoGioco getStatoGioco() {
        return this.statoGioco;
    }

    public void faiMossa(IGiocatore<CartaNapoletana> giocatore, CartaNapoletana carta) {
        // TODO: implementare
        // cambiare il mazzo, il tavolo da gioco e quant'altro
        // valutare lo stato di gioco e in caso cambiarlo
    }
}
