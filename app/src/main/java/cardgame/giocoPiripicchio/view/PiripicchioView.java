package cardgame.giocoPiripicchio.view;

import java.util.Collection;
import java.util.List;

import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.gioco.MossaPiripicchio;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.libreria.view.AbstractView;

public interface PiripicchioView extends AbstractView<CartaNapoletana, GiocatorePiripicchio> {

    public void notificaVincitori(Collection<String> vincitori);

    public MossaPiripicchio chiediMossa(GiocatorePiripicchio giocatore);

    public GiocatorePiripicchio chiediAltroGiocatore(List<GiocatorePiripicchio> giocatori);
}
