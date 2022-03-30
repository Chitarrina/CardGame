package cardgame.giocoPiripicchio.gioco;

import java.util.Arrays;
import java.util.List;

import cardgame.giocoPiripicchio.controller.PiripicchioController;
import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.model.CartaNapoletana;
import cardgame.giocoPiripicchio.model.MazzoNapoletane;
import cardgame.giocoPiripicchio.model.SemiCarteNapoletane;
import cardgame.giocoPiripicchio.view.PiripicchioView;
import cardgame.libreria.exception.CartaException;
import cardgame.libreria.gioco.IGioco;

public class Piripicchio implements IGioco {
    private PiripicchioModel model;
    private PiripicchioView view;
    private List<GiocatorePiripicchio> giocatori;
    private PiripicchioController controller;
    private int turno;
    private MazzoNapoletane mazzo;

    public Piripicchio(PiripicchioGameParameters parametri, PiripicchioModel model, PiripicchioView view,
            PiripicchioController controller, List<GiocatorePiripicchio> giocatori) {
        this.model = model;
        this.view = view;
        this.giocatori = giocatori;
        this.controller = controller;
    }

    /** 
     * Il metodo: 
     * inizializza il turno a 0 
     * utilizza il metodo inizializzaPiripicchio() [vedi javaDoc nel model (PiripicchioModel)]
     * distribuisce le carte ai giocatori
     * ognuno di loro scopre una carta dal loro stack di carte coperte
     * 
     * Dopodichè inizia il sistema a turni dove ogni giocatore fa la sua mossa
     * 
     * Nel caso di un giocatore vincitore, esso viene notificato alla view
     */
    @Override
    public void gioca() throws CartaException{
        this.turno = 0;
        creaMazzo();
        model.inizializzaPiripicchio();

        distribuisciCarte();
        scopriPrimaCarta();

        while (!model.isGiocoFinito()) {
            giocaMossa();
            turno = (turno + 1) % giocatori.size();
        }

        view.notificaVincitori(Arrays.asList(getVincitore()));
    }
    /** 
     * La mossa è giocabile se:
     *     il gioco non è finito
     *     il giocatore non gioca PASSA
     * viene chiesta al giocatore la mossa (la quale viene successivamente verificata)
     * 
     * Se la mossa è compatibile:
     *     ATTACCA_TAVOLO attaccherà la carta al tavolo
     *     
     *     ATTACCA_GIOCATORE attaccherà la carta dal giocatore mittente al destinatario
     *     
     *     SWAP eseguirà un Soft o Hard Swap (usabile UNA sola volta)
     * 
     * Se il giocatore esegue ATTACCA_TAVOLO / _GIOCATORE con successo ha diritto a rieffettuare una mossa
     */
    private void giocaMossa() {
        GiocatorePiripicchio giocatore = giocatori.get(turno);
        MossaPiripicchio mossa;
        boolean swapUsato = false;
        do {
            if (model.isGiocoFinito()) {
                break;
            }

            do {
                mossa = giocatore.chiediMossa();
            } while (!model.isMossaAmmessa(giocatore, mossa));

            if (mossa == MossaPiripicchio.PASSA) {
                break;
            }

            if (mossa == MossaPiripicchio.ATTACCA_TAVOLO) {
                controller.attaccaTavolo(giocatore);
            }

            if (mossa == MossaPiripicchio.ATTACCA_GIOCATORE) {
                List<GiocatorePiripicchio> giocatoriCompatibili = model.getGiocatoriCompatibili(giocatore);
                GiocatorePiripicchio altroGiocatore = giocatore.chiediAltroGiocatore(giocatoriCompatibili);
                controller.attaccaGiocatore(giocatore, altroGiocatore);
            }

            if (mossa == MossaPiripicchio.SWAP) {
                if (swapUsato) {
                    break;
                }
                controller.swap(giocatore);
                swapUsato = true;
            }
        } while (true);
    }
    /** 
     * Il metodo distribuisce le carte del mazzo di carte
     * inserendolo nel loro rispettivo stack di carte coperte
     */
    private void distribuisciCarte() throws CartaException{
        int carteATesta = mazzo.getNumTotalCards() / giocatori.size();
        for (int i = 0; i < giocatori.size(); i++) {
            for (int j = 0; j < carteATesta; j++) {
                model.daiCartaCoperta(giocatori.get(turno), mazzo.draw());
            }
            turno = (turno + 1) % giocatori.size();
        }
    }

    private void scopriPrimaCarta() {
        this.giocatori.forEach(model::scopriCarta);
    }
    /** 
     * Il metodo crea un mazzo di carte napoletane con situazioni particolari
     * 
     * Nel caso di 3 giocatori viene rimosso il re di bastoni
     * Nel caso di 6 giocatori vengono rimossi tutti i re
     */
    private void creaMazzo() throws CartaException{
        this.mazzo = new MazzoNapoletane();
        switch (this.giocatori.size()) {
            case 3:
                this.mazzo.rimuoviCarta(new CartaNapoletana(9, SemiCarteNapoletane.BASTONI));
                break;
            case 6:
                for(SemiCarteNapoletane s : SemiCarteNapoletane.values()){
                    this.mazzo.rimuoviCarta(new CartaNapoletana(9, s));
                }
                break;
        }
    }

    /** 
     * Mi restituisce il nome del giocatore vincitore:
     * 
     * Il metodo mi mostra la situazione delle carte dei vari giocatori a gioco concluso
     * Un giocatore è vincitore nel caso in cui il suo stack di carte coperte e scoperte è vuoto
     * 
     * @return String nome del giocatore vincitore
     */
    private String getVincitore() {
        System.out.println("\n\nVediamo le carte dei giocatori:\n");
        for (GiocatorePiripicchio g : giocatori) {
            System.out.println("Situazione giocatore: " + g);
            System.out.println("Carte scoperte: ");
            model.getCarteScoperte(g).forEach(System.out::println);
            System.out.println("Carte coperte: ");
            model.getCarteCoperte(g).forEach(System.out::println);
            System.out.println("");
        }

        for (GiocatorePiripicchio giocatore : this.giocatori) {
            if (model.getCarteScoperte(giocatore).size() == 0 && model.getCarteCoperte(giocatore).size() == 0) {
                return giocatore.getNome();
            }
        }
        return null;
    }
}