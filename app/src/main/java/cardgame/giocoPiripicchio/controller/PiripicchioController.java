package cardgame.giocoPiripicchio.controller;

import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.libreria.controller.AbstractController;

public interface PiripicchioController extends AbstractController<CartaNapoletana, GiocatorePiripicchio> {

    public void attaccaTavolo(GiocatorePiripicchio giocatore);

    public void attaccaGiocatore(GiocatorePiripicchio giocatore, GiocatorePiripicchio altroGiocatore);

    public void swap(GiocatorePiripicchio giocatore);
}
