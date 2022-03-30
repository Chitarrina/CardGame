package cardgame.giocoPiripicchio.giocatore;

import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.giocoPiripicchio.view.PiripicchioView;
import cardgame.libreria.giocatore.AbstractPlayerFactory;

public interface AbstractPiripicchioPlayerFactory extends
                AbstractPlayerFactory<CartaNapoletana, GiocatorePiripicchio, PiripicchioGameParameters, PiripicchioView> {

}
