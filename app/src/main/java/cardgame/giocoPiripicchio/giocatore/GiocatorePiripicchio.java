package cardgame.giocoPiripicchio.giocatore;

import java.util.List;

import cardgame.giocoPiripicchio.gioco.MossaPiripicchio;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.libreria.giocatore.Giocatore;

public abstract class GiocatorePiripicchio extends Giocatore<CartaNapoletana> {

    public GiocatorePiripicchio(String nome) {
        super(nome);
    }

    public abstract MossaPiripicchio chiediMossa();

    public abstract GiocatorePiripicchio chiediAltroGiocatore(List<GiocatorePiripicchio> giocatori);
}
