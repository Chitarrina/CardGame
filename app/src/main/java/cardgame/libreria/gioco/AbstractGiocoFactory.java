package cardgame.libreria.gioco;

import java.util.List;

import cardgame.libreria.controller.AbstractController;
import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.model.AbstractModel;
import cardgame.libreria.model.ICarta;
import cardgame.libreria.view.AbstractView;

@FunctionalInterface
public interface AbstractGiocoFactory<P extends IGameParameters, M extends AbstractModel<K, G, P>, V extends AbstractView<K, G>, C extends AbstractController<K, G>, K extends ICarta, G extends IGiocatore<K>, A extends IGioco> {
    //Interfaccia per creare famiglie di oggetti Gioco
    public A createGioco(P parametri, M model, V view, C controller, List<G> giocatori);
}