package cardgame.giocoPiripicchio.controller;

import cardgame.giocoPiripicchio.model.PiripicchioModel;

public class PiripicchioSempliceControllerFactory implements AbstractPiripicchioControllerFactory {

    @Override
    public PiripicchioSempliceController createController(PiripicchioModel model) {
        return new PiripicchioSempliceController(model);
    }
}
