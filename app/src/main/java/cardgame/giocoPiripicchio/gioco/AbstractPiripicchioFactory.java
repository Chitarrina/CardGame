package cardgame.giocoPiripicchio.gioco;

import cardgame.giocoPiripicchio.controller.PiripicchioController;
import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.giocoPiripicchio.view.PiripicchioView;
import cardgame.libreria.gioco.AbstractGiocoFactory;

public interface AbstractPiripicchioFactory extends
                AbstractGiocoFactory<PiripicchioGameParameters, PiripicchioModel, PiripicchioView, PiripicchioController, CartaNapoletana, GiocatorePiripicchio, Piripicchio> {

}