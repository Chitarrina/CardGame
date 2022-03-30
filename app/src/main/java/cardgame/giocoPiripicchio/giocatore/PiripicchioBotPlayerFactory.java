package cardgame.giocoPiripicchio.giocatore;

import java.util.Random;

import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.giocoPiripicchio.view.PiripicchioView;

public class PiripicchioBotPlayerFactory implements AbstractPiripicchioPlayerFactory {
    
    @Override
    public GiocatorePiripicchioBot createPlayer(PiripicchioGameParameters parameters, PiripicchioView view,
            Random random) {
        return new GiocatorePiripicchioBot("Bot", random);
    }
}
