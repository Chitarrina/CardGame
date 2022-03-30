package cardgame.libreria.model;

import java.beans.PropertyChangeListener;

import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.gioco.IGameParameters;

public interface AbstractModel<K extends ICarta, G extends IGiocatore<K>, P extends IGameParameters> {
    
    boolean isGiocoFinito();

    P getParametriGioco();

    void addListener(PropertyChangeListener listener);

    void addPlayer(G giocatore);
}
