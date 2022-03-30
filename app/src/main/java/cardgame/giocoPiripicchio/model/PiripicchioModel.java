package cardgame.giocoPiripicchio.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import cardgame.giocoPiripicchio.giocatore.GiocatorePiripicchio;
import cardgame.giocoPiripicchio.gioco.MossaPiripicchio;
import cardgame.giocoPiripicchio.gioco.PiripicchioGameParameters;
import cardgame.libreria.model.AbstractModel;

public class PiripicchioModel
        implements AbstractModel<CartaNapoletana, GiocatorePiripicchio, PiripicchioGameParameters> {

    private PropertyChangeSupport listeners;
    private PiripicchioGameParameters parametri;
    private Map<SemiCarteNapoletane, Collection<CartaNapoletana>> tavolo;
    private Map<GiocatorePiripicchio, Stack<CartaNapoletana>> carteScoperte;
    private Map<GiocatorePiripicchio, Stack<CartaNapoletana>> carteCoperte;

    public PiripicchioModel(PiripicchioGameParameters parametri) {
        this.parametri = parametri;
        this.listeners = new PropertyChangeSupport(this);
        this.tavolo = new HashMap<SemiCarteNapoletane, Collection<CartaNapoletana>>();
        this.carteScoperte = new HashMap<GiocatorePiripicchio, Stack<CartaNapoletana>>();
        this.carteCoperte = new HashMap<GiocatorePiripicchio, Stack<CartaNapoletana>>();
        inizializzaPiripicchio();
    }
    /** 
     * Il metodo inizializza il gioco:
     * 
     * Tavolo vuoto, vengono istanziati i 4 stack di carte vuoti
     * Vengono creati gli stack vuoti di carte coperte e scoperte
     */
    public void inizializzaPiripicchio() {
        this.tavolo.clear();
        Arrays.asList(SemiCarteNapoletane.values()).forEach(s -> {
            this.tavolo.put(s, new Stack<CartaNapoletana>());
        });
        this.carteScoperte.keySet().forEach(p -> this.carteScoperte.put(p, new Stack<CartaNapoletana>()));
        this.carteCoperte.keySet().forEach(p -> this.carteCoperte.put(p, new Stack<CartaNapoletana>()));
    }

    
    /** 
     * Effettuo una stream controllando le carte scoperte e coperte di tutti i giocatori,
     * se un qualsiasi giocatore finisce entrambi gli stack, allora il gioco finisce (true)
     * 
     * altrimenti restituisce false
     * 
     * @return boolean
     */
    @Override
    public boolean isGiocoFinito() {
        return this.carteScoperte.keySet().stream().anyMatch(p -> {
            return this.carteScoperte.get(p).size() == 0 && this.carteCoperte.get(p).size() == 0;
        });
    }

    @Override
    public PiripicchioGameParameters getParametriGioco() {
        return this.parametri;
    }

    
    /** 
     * Il seguente metodo aggiunge un listener che ha lo scopo di notificare la view nel momento in cui il
     * model ha un cambiamento
     * 
     * @param listener
     */
    @Override
    public void addListener(PropertyChangeListener listener) {
        this.listeners.addPropertyChangeListener(listener);
    }

    
    /** 
     * Dato un giocatore, esso viene aggiunto alle due mappe e creati i due nuovi stack
     *     Le carte scoperte
     *     Le carte coperte
     * @param giocatore il giocatore da aggiungere
     */
    @Override
    public void addPlayer(GiocatorePiripicchio giocatore) {
        carteScoperte.put(giocatore, new Stack<CartaNapoletana>());
        carteCoperte.put(giocatore, new Stack<CartaNapoletana>());
    }

    
    /** 
     * Restituisce il tavolo formato da una mappa di Collezioni di Semi (quindi avremo 4 mazzetti)
     * 
     * @return Map<SemiCarteNapoletane, Collection<CartaNapoletana>>
     */
    public Map<SemiCarteNapoletane, Collection<CartaNapoletana>> getTavolo() {
        return this.tavolo;
    }

    
    /** 
     * Dato un giocatore e una carta, il metodo aggiunge la carta allo stack di carte
     * coperte del giocatore
     * 
     * @param giocatore il target giocatore
     * @param carta la carta da aggiungere allo stack
     */
    public void daiCartaCoperta(GiocatorePiripicchio giocatore, CartaNapoletana carta) {
        this.carteCoperte.get(giocatore).add(carta);
    }

    
    /** 
     * Dato un giocatore, il metodo fa la pop (quindi prende la carta in cima dallo stack)
     * dal mazzertto carteCoperte e la aggiunge allo stack delle carteScoperte
     * 
     * @param giocatore il target giocatore
     */
    public void scopriCarta(GiocatorePiripicchio giocatore) {
        CartaNapoletana carta = this.carteCoperte.get(giocatore).pop();
        this.carteScoperte.get(giocatore).add(carta);
        this.listeners.firePropertyChange("scopri", null, giocatore);
    }

    
    /** 
     * Restituisce true se: 
     *     il giocatore ha carte scoperte da giocare
     *     è possibile attaccarla al tavolo se:
     *         è possibile fare una scala dall' [asso in su] con la carta)
     *         il seme della carta da attaccare sia lo stesso
     * 
     * false altrmenti
     * 
     * @param giocatore il giocatore target
     * @return boolean
     */
    private boolean isAttaccaTavoloAmmessso(GiocatorePiripicchio giocatore) {
        if (this.carteScoperte.get(giocatore).size() == 0) {
            return false;
        }
        CartaNapoletana cartaScoperta = this.carteScoperte.get(giocatore).peek();
        return cartaScoperta.getValue() == 0 || this.tavolo.get(cartaScoperta.getSeed()).contains(
                new CartaNapoletana(cartaScoperta.getValue() - 1, cartaScoperta.getSeed()));
    }

    
    /** 
     * Restituisce true se:
     *     ha una carta scoperta da giocare
     *     il giocatore ha una carta che è +-1 il valore della carta del giocatore destinatario
     * 
     * @param giocatore il giocatore target
     * @return boolean
     */
    private boolean isAttaccaGiocatoreAmmessso(GiocatorePiripicchio giocatore) {
        if (this.carteScoperte.get(giocatore).size() == 0) {
            return false;
        }
        CartaNapoletana cartaScoperta = this.carteScoperte.get(giocatore).peek();
        Collection<CartaNapoletana> carteScoperteAltriGiocatori = carteScoperte.keySet().stream()
                .filter(p -> !p.getNome().equals(giocatore.getNome())).filter(p -> this.carteScoperte.get(p).size() > 0)
                .map(p -> this.carteScoperte.get(p).peek())
                .collect(Collectors.toList());
        return carteScoperteAltriGiocatori.stream()
                .anyMatch(c -> cartaScoperta.getValue() == c.getValue() + 1
                        || cartaScoperta.getValue() == c.getValue() - 1);
    }

    
    /** 
     * Il metodo è una serie di switch case che mi innesca il check 
     * sui vari metodi ammissibili in base alla mossa che vuole fare
     * il giocatore. Tutto ciò per rispettare il code smell (metodi non piu di 10 righe)
     * e favorire la riusabilità ed estendibilità di codice
     * 
     *     restituisce true se:
     *         nella mossa ATTACCA_TAVOLO il giocatore può effettivamente farlo
     *         nella mossa ATTACCA_GIOCATORE il giocatore non può attaccare carte sul tavolo
     *             il giocatore può effettivamente farlo
     * 
     *         nella mossa SWAP non può ne attaccare carte al tavolo ne ai giocatori
     *          
     *         mossa PASSA sempre concessa
     * 
     * @param giocatore il giocatore target
     * @param mossa la mossa che vuole fare
     * 
     * @return boolean
     */
    public boolean isMossaAmmessa(GiocatorePiripicchio giocatore, MossaPiripicchio mossa) {
        switch (mossa) {
            case ATTACCA_TAVOLO:
                return isAttaccaTavoloAmmessso(giocatore);
            case ATTACCA_GIOCATORE:
                if (isAttaccaTavoloAmmessso(giocatore)) {
                    return false;
                }
                return isAttaccaGiocatoreAmmessso(giocatore);
            case SWAP:
                return !isAttaccaTavoloAmmessso(giocatore) && !isAttaccaGiocatoreAmmessso(giocatore);
            case PASSA:
                return true;
            default:
                return false;
        }
    }

    
    /** 
     * Dato un giocatore il metodo toglie una carta dalla cima dello stack delle carte scoperte
     * e la inserisce nel rispettivo seme nel tavolo
     * 
     * tramite il listener viene notificata la view del cambiamento al tavolo
     * 
     * @param giocatore il giocatore target
     */
    public void attaccaTavolo(GiocatorePiripicchio giocatore) {
        CartaNapoletana carta = this.carteScoperte.get(giocatore).pop();
        this.tavolo.get(carta.getSeed()).add(carta);
        listeners.firePropertyChange("tavolo", null, this.tavolo);
    }

    
    /** 
     * Dato un giocatore mittente e giocatore destinatario il metodo attacca la carta al destinatario:
     * la carta viene tolta dalla cima dello stack delle carte scoperte del mittente e viene inserita
     * nello stack delle carte scoperte del destinatario
     * 
     * il listener notifica la view del cambiamento delle carte dei giocatori
     * @param giocatore
     * @param altroGiocatore
     */
    public void attaccaGiocatore(GiocatorePiripicchio giocatore, GiocatorePiripicchio altroGiocatore) {
        CartaNapoletana carta = this.carteScoperte.get(giocatore).pop();
        this.carteScoperte.get(altroGiocatore).add(carta);
        listeners.firePropertyChange("attacca", null, Arrays.asList(giocatore, altroGiocatore, carta));
    }

    
    /** 
     * Dato un giocatore il metodo fa un (Hard Swap o un Soft Swap)
     * 
     * Soft Swap:
     * Prende una carta dalla cima delle carte coperte e la inserisce nella
     * cima delle carte scoperte
     * 
     * Hard Swap:
     * Se il giocatore non ha piu carte tra le carte coperte, le carte scoperte diventano
     * le carte coperte e ne viene invertito l'ordine [pop -> push]
     * 
     * viene notificata la view dello swap avvenuto
     * 
     * @param giocatore il giocatore target
     */
    public void swap(GiocatorePiripicchio giocatore) {
        if (this.carteCoperte.get(giocatore).size() > 0) {
            scopriCarta(giocatore);
        } else {
            while (this.carteScoperte.get(giocatore).size() > 0) {
                CartaNapoletana cartaDaSwappare = this.carteScoperte.get(giocatore).pop();
                this.carteCoperte.get(giocatore).add(cartaDaSwappare);
            }
            scopriCarta(giocatore);
        }
        listeners.firePropertyChange("swap", null, giocatore);
    }

    
    /** 
     * Dato un giocatore il metodo restituisce il suo stack di carte scoperte
     * 
     * @param giocatore il giocatore target
     * @return Stack<CartaNapoletana> lo stack di carte scoperte
     */
    public Stack<CartaNapoletana> getCarteScoperte(GiocatorePiripicchio giocatore) {
        return this.carteScoperte.get(giocatore);
    }

    
    /** 
     * Dato un giocatore il metodo restiuisce il suo stack di carte coperte
     * 
     * @param giocatore il giocatore target
     * @return Stack<CartaNapoletana> lo stack di carte coperte
     */
    public Stack<CartaNapoletana> getCarteCoperte(GiocatorePiripicchio giocatore) {
        return this.carteCoperte.get(giocatore);
    }

    
    /** 
     * Dato un giocatore il metodo restituisce quali giocatori sono compatibili al quale attaccare
     * la carta che ha in possesso il giocatore target
     * 
     * Il giocatore è compatibile se:
     *     Gli altri giocatori non sono il target (ovvio)
     *     Hanno carte scoperte
     *     La carta degli altri se il valore di essa è +-1 il valore della carta del target
     *     
     * @param giocatore il giocatore target
     * @return List<GiocatorePiripicchio> la lista di giocatori compatibili
     */
    public List<GiocatorePiripicchio> getGiocatoriCompatibili(GiocatorePiripicchio giocatore) {
        CartaNapoletana cartaScoperta = this.carteScoperte.get(giocatore).peek();
        List<GiocatorePiripicchio> giocatoriCompatibili = this.carteScoperte.keySet().stream()
                .filter(p -> !p.getNome().equals(giocatore.getNome()))
                .filter(p -> this.carteScoperte.get(p).size() > 0)
                .filter(p -> cartaScoperta.getValue() == this.carteScoperte.get(p).peek().getValue() + 1
                        || cartaScoperta.getValue() == this.carteScoperte.get(p).peek().getValue() - 1)
                .collect(Collectors.toList());
        return giocatoriCompatibili;
    }
}
