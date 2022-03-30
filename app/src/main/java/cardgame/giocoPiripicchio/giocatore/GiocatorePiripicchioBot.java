package cardgame.giocoPiripicchio.giocatore;

import java.util.List;
import java.util.Random;

import cardgame.giocoPiripicchio.gioco.MossaPiripicchio;

public class GiocatorePiripicchioBot extends GiocatorePiripicchio {

    private Random random;
    private static int counter = 1;

    public GiocatorePiripicchioBot(String nome, Random random) {
        super(nome + (counter++));
        this.random = random;
    }

    
    /** 
     * Il giocatore bot come mossa eseguirà una random tra quelle possibili
     * 
     * @return MossaPiripicchio la mossa casuale scelta
     */
    @Override
    public MossaPiripicchio chiediMossa() {
        return MossaPiripicchio.values()[this.random.nextInt(MossaPiripicchio.values().length)];
    }

    
    /** 
     * Il giocatore bot come giocatori possibili sceglierà uno random tra quelli proposti nella lista di giocatori
     * 
     * @param giocatori lista di giocatori
     * @return GiocatorePiripicchio il giocatore casuale scelto
     */
    @Override
    public GiocatorePiripicchio chiediAltroGiocatore(List<GiocatorePiripicchio> giocatori) {
        return giocatori.get(this.random.nextInt(giocatori.size()));
    }
}
