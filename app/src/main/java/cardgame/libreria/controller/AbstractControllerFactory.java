package cardgame.libreria.controller;

import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.gioco.IGameParameters;
import cardgame.libreria.model.AbstractModel;
import cardgame.libreria.model.ICarta;

@FunctionalInterface
public interface AbstractControllerFactory<C extends AbstractController<K, G>, K extends ICarta, M extends AbstractModel<K, G, P>, G extends IGiocatore<K>, P extends IGameParameters> {

    public C createController(M model);
}
