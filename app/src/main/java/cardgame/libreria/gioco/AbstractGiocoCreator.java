package cardgame.libreria.gioco;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import cardgame.libreria.controller.AbstractController;
import cardgame.libreria.controller.AbstractControllerFactory;
import cardgame.libreria.giocatore.AbstractPlayerFactory;
import cardgame.libreria.giocatore.IGiocatore;
import cardgame.libreria.model.AbstractModel;
import cardgame.libreria.model.AbstractModelFactory;
import cardgame.libreria.model.ICarta;
import cardgame.libreria.view.AbstractView;
import cardgame.libreria.view.AbstractViewFactory;

public interface AbstractGiocoCreator<P extends IGameParameters, M extends AbstractModel<K, G, P>, V extends AbstractView<K, G>, C extends AbstractController<K, G>, K extends ICarta, G extends IGiocatore<K>, A extends IGioco, I extends InputStream, O extends PrintStream> {

    public P getGameParameters();

    public AbstractModelFactory<K, M, P, G> getModelFactory();

    public AbstractViewFactory<V, P, K, M, C, G, I, O> getViewFactory();

    public AbstractControllerFactory<C, K, M, G, P> getControllerFactory();

    public AbstractGiocoFactory<P, M, V, C, K, G, A> getGiocoFactory();

    public Collection<? extends AbstractPlayerFactory<K, G, P, V>> getGiocatoriFactory();

    public I getInput();

    public O getOutput();

    public default A createGioco() {
        P parametri = getGameParameters();
        M model = getModelFactory().createModel(parametri);
        C controller = getControllerFactory().createController(model);
        V view = getViewFactory().createView(parametri, model, controller, getInput(), getOutput());
        model.addListener(view);
        List<G> giocatori = getGiocatoriFactory().stream()
                .map(x -> x.createPlayer(parametri, view, new Random()))
                .collect(Collectors.toList());
        giocatori.forEach(model::addPlayer);

        return getGiocoFactory().createGioco(parametri, model, view, controller, giocatori);
    }
}
