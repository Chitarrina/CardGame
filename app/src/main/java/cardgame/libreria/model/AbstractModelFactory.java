package cardgame.libreria.model;

import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.gioco.IGameParameters;

@FunctionalInterface
public interface AbstractModelFactory<K extends ICarta, M extends AbstractModel<K, G, P>, P extends IGameParameters, G extends IGiocatore<K>> {
    //Interfaccia per creare famiglie di oggetti model
    M createModel(P parametri);
}
