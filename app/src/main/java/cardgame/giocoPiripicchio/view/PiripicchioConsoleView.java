package cardgame.giocoPiripicchio.view;

import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.gioco.MossaPiripicchio;
import cardgame.giocoPiripicchio.model.PiripicchioModel;
import cardgame.giocoPiripicchio.model.SemiCarteNapoletane;
import cardgame.giocoPiripicchio.model.CartaNapoletana;

public class PiripicchioConsoleView implements PiripicchioView {

    private PiripicchioModel model;
    private InputStream input;
    private PrintStream output;

    public PiripicchioConsoleView(PiripicchioModel model, InputStream input, PrintStream output) {
        this.model = model;
        this.input = input;
        this.output = output;
    }

    /** 
     * Passato un evento il metodo notificherà sullo schermo l'evento accaduto
     * @param evt l'evento dato dall'esecuzione di una mossa
     */
    @SuppressWarnings("unchecked")
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //se l'evento ha come nome "scopri"
        if (evt.getPropertyName().equals("scopri")) {
            GiocatorePiripicchio giocatore = (GiocatorePiripicchio) evt.getNewValue();
            //mostrerò quale giocatore ha scoperto la carta
            output.println("Il giocatore " + giocatore + " ha scoperto la carta: "
                    + this.model.getCarteScoperte(giocatore).peek());
        }
        //se l'evento ha come nome "tavolo"
        if (evt.getPropertyName().equals("tavolo")) {
            output.println("\n\nVediamo le carte del Tavolo:");
            Map<SemiCarteNapoletane, Collection<CartaNapoletana>> tavolo = (Map<SemiCarteNapoletane, Collection<CartaNapoletana>>) evt
                    .getNewValue();
            //mostrerò le scale che si sono formate sul tavolo
            tavolo.entrySet().forEach(e -> {
                output.println("Seme: " + e.getKey());
                e.getValue().forEach(c -> output.print(c + "\n"));
                output.println("");
            });
        }
        //se l'evento ha come nome "attacca"
        if (evt.getPropertyName().equals("attacca")) {
            List<Object> dati = (List<Object>) evt.getNewValue();
            //viene notificata quale carta ha attaccato il giocatore mittente al giocatore destinatario
            output.println("Il giocatore " + dati.get(0) + " ha attaccato la carta " + dati.get(2) + " al giocatore "
                    + dati.get(1));
        }
        if (evt.getPropertyName().equals("swap")) {
            output.println("Il giocatore: " + evt.getNewValue() + " ha effettuato uno swap");
        }
    }

    /** 
     * Il metodo data una Collezione di vincitori la notifica a schermo
     * 
     * Attualmente viene proclamato un solo vincitore, ma nulla ci vieta in
     * futuro di creare una classifica di vincitori
     * 
     * @param vincitori la collection di vincitori da mostrare
     */
    @Override
    public void notificaVincitori(Collection<String> vincitori) {
        output.println("\nIl vincitore e':");
        vincitori.forEach(output::println);
    }

    /** 
     * Dato un giocatore, viene notificato a quest'ultimo le modalità per eseguirla
     * Il quale tramite input da tastiera deciderà quale eseguire
     * 
     * @param giocatore il giocatore target
     * @return MossaPiripicchio la mossa da eseguire
     */
    @Override
    public MossaPiripicchio chiediMossa(GiocatorePiripicchio giocatore) {
        output.println("Inserire mossa:");
        output.println("1) Attacca carta al tavolo");
        output.println("2) Attacca carta a giocatore");
        output.println("3) Swap");
        output.println("4) Passa");

        int sceltaMossa = -1;
        do {
            while (true) {
                BufferedReader scanner = new BufferedReader(new InputStreamReader(input));
                try {
                    sceltaMossa = Integer.parseInt(scanner.readLine());
                    break;
                } catch (Exception ex) {
                    output.println("Errore input");
                }
            }
        } while (sceltaMossa < 1 || sceltaMossa > 4);

        return MossaPiripicchio.values()[sceltaMossa - 1];
    }

    
    /** 
     * Il metodo mostrerà al giocatore la lista di giocatori e verrà chiesto a quale di questi
     * vorrà attaccare la carta
     * 
     * @param giocatori Lista di giocatori potenziali
     * @return GiocatorePiripicchio giocatore scelto dall'utente
     */
    @Override
    public GiocatorePiripicchio chiediAltroGiocatore(List<GiocatorePiripicchio> giocatori) {
        output.println("Giocatore a cui attaccare:");
        for (int i = 0; i < giocatori.size(); i++) {
            output.println((i + 1) + ") " + giocatori.get(i));
        }

        int sceltaGiocatore = -1;
        do {
            while (true) {
                BufferedReader scanner = new BufferedReader(new InputStreamReader(input));
                try {
                    sceltaGiocatore = Integer.parseInt(scanner.readLine());
                    break;
                } catch (Exception ex) {
                    output.println("Errore input");
                }
            }

        } while (sceltaGiocatore < 1 || sceltaGiocatore > giocatori.size());
        return giocatori.get(sceltaGiocatore - 1);
    }
}
