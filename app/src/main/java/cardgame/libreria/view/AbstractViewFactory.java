package cardgame.libreria.view;

import java.io.InputStream;
import java.io.PrintStream;

import cardgame.libreria.controller.AbstractController;
import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.gioco.IGameParameters;
import cardgame.libreria.model.AbstractModel;
import cardgame.libreria.model.ICarta;

@FunctionalInterface
public interface AbstractViewFactory<V extends AbstractView<K, G>, P extends IGameParameters, K extends ICarta, M extends AbstractModel<K, G, P>, C extends AbstractController<K, G>, G extends IGiocatore<K>, I extends InputStream, O extends PrintStream> {

    public V createView(P gameParameters, M model, C controller, I input, O output);
}
