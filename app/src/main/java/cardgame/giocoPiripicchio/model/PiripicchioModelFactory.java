package cardgame.giocoPiripicchio.model;

import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;

public class PiripicchioModelFactory implements AbstractPiripicchioModelFactory {
    
    @Override
    public PiripicchioModel createModel(PiripicchioGameParameters parametri) {
        return new PiripicchioModel(parametri);
    }
}
