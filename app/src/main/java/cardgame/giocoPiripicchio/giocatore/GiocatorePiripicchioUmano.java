package cardgame.giocoPiripicchio.giocatore;

import java.util.List;

import cardgame.giocoPiripicchio.gioco.MossaPiripicchio;
import cardgame.giocoPiripicchio.view.PiripicchioView;

public class GiocatorePiripicchioUmano extends GiocatorePiripicchio {

    private PiripicchioView view;

    public GiocatorePiripicchioUmano(String nome, PiripicchioView view) {
        super(nome);
        this.view = view;
    }

    
    /** 
     * Il metodo richiama la view che chiederà a schermo quale mossa vuole eseguire il giocatore
     * @return MossaPiripicchio la mossa che vuole fare il giocatore
     */
    @Override
    public MossaPiripicchio chiediMossa() {
        return view.chiediMossa(this);
    }

    
    /** 
     * Data una lista di giocatori, il metodo richiamerà la view che chiederà a schermo su quale giocatore di destinazione
     * il giocatore mittente intende fare fa mossa
     * 
     * @param giocatori la lista di giocatori
     * @return GiocatorePiripicchio il giocatore di piripicchio di destinazione
     */
    @Override
    public GiocatorePiripicchio chiediAltroGiocatore(List<GiocatorePiripicchio> giocatori) {
        return view.chiediAltroGiocatore(giocatori);
    }
}
