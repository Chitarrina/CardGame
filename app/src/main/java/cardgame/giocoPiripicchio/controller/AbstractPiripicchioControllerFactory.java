package cardgame.giocoPiripicchio.controller;

import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.libreria.controller.AbstractControllerFactory;

public interface AbstractPiripicchioControllerFactory extends
        AbstractControllerFactory<PiripicchioController, CartaNapoletana, PiripicchioModel, GiocatorePiripicchio, PiripicchioGameParameters> {

}
