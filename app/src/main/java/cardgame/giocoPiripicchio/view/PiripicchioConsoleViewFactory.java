package cardgame.giocoPiripicchio.view;

import java.io.InputStream;
import java.io.PrintStream;

import cardgame.giocoPiripicchio.controller.PiripicchioController;
import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.giocoPiripicchio.model.PiripicchioModel;

public class PiripicchioConsoleViewFactory implements AbstractPiripicchioViewFactory {

    @Override
    public PiripicchioConsoleView createView(PiripicchioGameParameters gameParameters, PiripicchioModel model,
            PiripicchioController controller, InputStream input, PrintStream output) {
        return new PiripicchioConsoleView(model, input, output);
    }
}
