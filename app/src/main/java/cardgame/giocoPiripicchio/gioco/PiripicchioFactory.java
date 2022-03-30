package cardgame.giocoPiripicchio.gioco;

import java.util.List;

import cardgame.giocoPiripicchio.controller.PiripicchioController;
import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.view.PiripicchioView;

public class PiripicchioFactory implements AbstractPiripicchioFactory {
    
    @Override
    public Piripicchio createGioco(PiripicchioGameParameters parametri, PiripicchioModel model, PiripicchioView view,
            PiripicchioController controller, List<GiocatorePiripicchio> giocatori) {
        return new Piripicchio(parametri, model, view, controller, giocatori);
    }
}