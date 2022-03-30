package cardgame.giocoPiripicchio.giocatore;

import java.util.Random;

import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.giocoPiripicchio.view.PiripicchioView;

public class PiripicchioHumanPlayerFactory implements AbstractPiripicchioPlayerFactory {
    
    private String nomePlayer;

    public PiripicchioHumanPlayerFactory(String nomePlayer) {
        this.nomePlayer = nomePlayer;
    }

    @Override
    public GiocatorePiripicchioUmano createPlayer(PiripicchioGameParameters parameters, PiripicchioView view,
            Random random) {
        return new GiocatorePiripicchioUmano(this.nomePlayer, view);
    }
}
