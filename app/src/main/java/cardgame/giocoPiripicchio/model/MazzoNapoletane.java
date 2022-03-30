package cardgame.giocoPiripicchio.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cardgame.libreria.exception.CartaException;
import cardgame.libreria.model.Mazzo;

public class MazzoNapoletane extends Mazzo<CartaNapoletana> {

    /** 
     * Collection di un mazzo di carte napoletane:
     * 
     * Valori: Dall'asso fino al re
     * Semi: Spade, Bastoni, Coppe, Denari
     */
    private static final Collection<CartaNapoletana> MAZZO_CARTE_NAPOLETANE = Arrays
            .asList(SemiCarteNapoletane.values()).stream()
            .flatMap(s -> IntStream.range(0, 10).mapToObj(i -> new CartaNapoletana(i, s)))
            .collect(Collectors.toList());

    public MazzoNapoletane() {
        super(MAZZO_CARTE_NAPOLETANE);
    }

    
    /** 
     * Il metodo data una carta napoletana la rimuove dal mazzo
     * @param carta 
     * @throws Exception
     */
    public void rimuoviCarta(CartaNapoletana carta) throws CartaException{
        for (int i = 0; i < this.getNumActualCards(); i++) {
            if (this.showCard(i).equals(carta)) {
                this.pickCard(i);
                return;
            }
        }
    }
}
