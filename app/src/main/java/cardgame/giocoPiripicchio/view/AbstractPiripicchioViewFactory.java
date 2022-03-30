package cardgame.giocoPiripicchio.view;

import java.io.InputStream;
import java.io.PrintStream;

import cardgame.giocoPiripicchio.controller.PiripicchioController;
import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.libreria.view.AbstractViewFactory;

public interface AbstractPiripicchioViewFactory extends
        AbstractViewFactory<PiripicchioView, PiripicchioGameParameters, CartaNapoletana, PiripicchioModel, PiripicchioController, GiocatorePiripicchio, InputStream, PrintStream> {

}
