package cardgame.giocoPiripicchio.gioco;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import cardgame.giocoPiripicchio.controller.PiripicchioController;
import cardgame.giocoPiripicchio.controller.PiripicchioSempliceControllerFactory;
import cardgame.giocoPiripicchio.controller.AbstractPiripicchioControllerFactory;
import cardgame.giocoPiripicchio.giocatore.AbstractPiripicchioPlayerFactory;
import cardgame.giocoPiripicchio.giocatore.PiripicchioBotPlayerFactory;
import cardgame.giocoPiripicchio.giocatore.PiripicchioHumanPlayerFactory;
import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.model.AbstractPiripicchioModelFactory;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.model.PiripicchioModelFactory;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.giocoPiripicchio.view.PiripicchioView;
import cardgame.giocoPiripicchio.view.AbstractPiripicchioViewFactory;
import cardgame.giocoPiripicchio.view.PiripicchioConsoleViewFactory;
import cardgame.libreria.gioco.AbstractGiocoCreator;

public class PiripicchioCreator implements
        AbstractGiocoCreator<PiripicchioGameParameters, PiripicchioModel, PiripicchioView, PiripicchioController, CartaNapoletana, GiocatorePiripicchio, Piripicchio, InputStream, PrintStream> {

    @Override
    public PiripicchioGameParameters getGameParameters() {
        return new PiripicchioGameParameters();
    }

    @Override
    public AbstractPiripicchioModelFactory getModelFactory() {
        return new PiripicchioModelFactory();
    }

    @Override
    public AbstractPiripicchioViewFactory getViewFactory() {
        return new PiripicchioConsoleViewFactory();
    }

    @Override
    public AbstractPiripicchioControllerFactory getControllerFactory() {
        return new PiripicchioSempliceControllerFactory();
    }

    @Override
    public AbstractPiripicchioFactory getGiocoFactory() {
        return new PiripicchioFactory();
    }

    @Override
    public InputStream getInput() {
        return System.in;
    }

    @Override
    public PrintStream getOutput() {
        return System.out;
    }

    public void getRegole(){
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|                            Regole di Piripicchio                             |");
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("| 1) Ogni giocatore avra' 2 mazzetti di carte:                                 |");
        System.out.println("|    Un mazzetto di carte coperte e uno di carte scoperte                      |");
        System.out.println("|    I giocatori potranno disfarsi solo delle carte del mazzetto scoperto      |");
        System.out.println("|                                                                              |");
        System.out.println("| 2) Lo scopo del gioco e' FINIRE le carte dei propri mazzetti                 |");
        System.out.println("|                                                                              |");
        System.out.println("| 3) E' un gioco a turni (i turni sono in rotazione)                           |");
        System.out.println("|                                                                              |");
        System.out.println("| 4) Ci sono 2 modi per disfarsi delle carte:                                  |");
        System.out.println("|        - Attaccarle al tavolo                                                |");
        System.out.println("|        - Attaccarle ad altri giocatori                                       |");
        System.out.println("|                                                                              |");
        System.out.println("|    Attaccarle al tavolo (Priorita' piu' alta)                                |");
        System.out.println("|        Se si possiede un asso, questo dovra' essere messo al tavolo e        |");
        System.out.println("|        continuata la scala del relativo seme                                 |");
        System.out.println("|                                                                              |");
        System.out.println("|    Attaccarle ad altri giocatori (Priorita' piu' bassa)                      |");
        System.out.println("|        Si puo' attaccare carte ad altri giocatori se:                        |");
        System.out.println("|            - Non e' possibile continuare eventuali scale nel tavolo          |");
        System.out.println("|            - Gli altri giocatori hanno come valore della loro carta scoperta |");
        System.out.println("|              di + o - 1 rispetto alla nostra (non importa il seme)           |");
        System.out.println("|                                                                              |");
        System.out.println("| 5) Nel caso in cui non e' possibile attaccare carte al tavolo o ai giocatori |");
        System.out.println("|    e' possibile fare uno (ed UNO solo durante il proprio turno) SWAP e       |");
        System.out.println("|    cambiare una carta coperta mettendola nel mazzetto di quelle scoperte     |");
        System.out.println("|    quest' ultima potra' essere giocata nel turno                             |");
        System.out.println("|                                                                              |");
        System.out.println("| 6) Nel caso in cui non abbiamo piu carte coperte e' possibile fare un        |");
        System.out.println("|    HARD SWAP, le carte scoperte verranno quindi ribaltate, diventaranno      |");
        System.out.println("|    coperte e verra' presa quella piu in cima e messa come nuova ed unica     |");
        System.out.println("|    carta scoperta                                                            |");
        System.out.println("|                                                                              |");
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|       Vince il giocatore che per primo finisce entrambi i mazzetti!          |");
        System.out.println("+------------------------------------------------------------------------------+\n\n");

    }

    @Override
    public Collection<AbstractPiripicchioPlayerFactory> getGiocatoriFactory() {
        getRegole();
        getOutput().println("Inserire numero giocatori tra 3 e 6");
        int numeroGiocatori = -1;
        do {
            while (true) {
                BufferedReader scanner = new BufferedReader(new InputStreamReader(getInput()));
                try {
                    numeroGiocatori = Integer.parseInt(scanner.readLine());
                    break;
                } catch (Exception ex) {
                    getOutput().println("Errore input");
                }
            }
        } while (numeroGiocatori < 3 || numeroGiocatori > 6);

        Collection<AbstractPiripicchioPlayerFactory> giocatori = new ArrayList<AbstractPiripicchioPlayerFactory>();
        for (int i = 0; i < numeroGiocatori; i++) {
            getOutput().println("Giocatore " + (i + 1) + ":");
            getOutput().println("Inserire tipo giocatore");
            getOutput().println("1) Umano");
            getOutput().println("2) Bot");

            int tipoGiocatore = -1;
            do {
                while (true) {
                    BufferedReader scanner = new BufferedReader(new InputStreamReader(getInput()));
                    try {
                        tipoGiocatore = Integer.parseInt(scanner.readLine());
                        break;
                    } catch (Exception ex) {
                        getOutput().println("Errore input");
                    }
                }
            } while (tipoGiocatore < 1 || tipoGiocatore > 2);

            String nomeGiocatore = null;
            if (tipoGiocatore == 1) {
                getOutput().println("Inserire nome giocatore");
                do {
                    while (true) {
                        BufferedReader scanner = new BufferedReader(new InputStreamReader(getInput()));
                        try {
                            String line = scanner.readLine().trim();
                            if (line.length() == 0) {
                                continue;
                            }
                            nomeGiocatore = line;
                            break;
                        } catch (Exception ex) {
                            getOutput().println("Errore input");
                        }
                    }
                } while (nomeGiocatore == null);
            }

            AbstractPiripicchioPlayerFactory nuovoGiocatoreFactory = tipoGiocatore == 1
                    ? new PiripicchioHumanPlayerFactory(nomeGiocatore)
                    : new PiripicchioBotPlayerFactory();
            giocatori.add(nuovoGiocatoreFactory);
        }
        return giocatori;
    }
}