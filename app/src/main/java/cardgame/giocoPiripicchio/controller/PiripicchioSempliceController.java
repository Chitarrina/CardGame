package cardgame.giocoPiripicchio.controller;

import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.model.PiripicchioModel;

public class PiripicchioSempliceController implements PiripicchioController {

    private PiripicchioModel model;

    public PiripicchioSempliceController(PiripicchioModel model) {
        this.model = model;
    }

    @Override
    public void attaccaTavolo(GiocatorePiripicchio giocatore) {
        this.model.attaccaTavolo(giocatore);
    }

    @Override
    public void attaccaGiocatore(GiocatorePiripicchio giocatore, GiocatorePiripicchio altroGiocatore) {
        this.model.attaccaGiocatore(giocatore, altroGiocatore);
    }

    @Override
    public void swap(GiocatorePiripicchio giocatore) {
        this.model.swap(giocatore);
    }
}
