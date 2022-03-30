package cardgame.libreria.view;

import java.beans.PropertyChangeListener;

import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.model.ICarta;

public interface AbstractView<K extends ICarta, G extends IGiocatore<K>> extends PropertyChangeListener {

}
