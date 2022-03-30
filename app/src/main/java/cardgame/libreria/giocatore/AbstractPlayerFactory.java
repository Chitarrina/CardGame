package cardgame.libreria.giocatore;

import java.util.Random;

import cardgame.libreria.gioco.IGameParameters;
import cardgame.libreria.model.ICarta;
import cardgame.libreria.view.AbstractView;

@FunctionalInterface
public interface AbstractPlayerFactory<K extends ICarta, G extends IGiocatore<K>, P extends IGameParameters, V extends AbstractView<K, G>> {
    //Interfaccia per creare famiglie di oggetti Giocatore
    public G createPlayer(P parameters, V view, Random random);
}
