package cardgame.libreria.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cardgame.libreria.exception.CartaException;

public class Mazzo<TCarta extends ICarta> implements IMazzo<TCarta> {

    private List<TCarta> mazzo;
    private int cartePescate;

    public Mazzo(Collection<TCarta> carte) {
        this.mazzo = new ArrayList<TCarta>(carte);
        this.shuffle();
        this.cartePescate = 0;
    }

    
    /** 
     * Restituisce il numero di carte attuali del mazzo, tenendo
     * in considerazione il numero di carte pescate
     * 
     * @return int
     */
    @Override
    public int getNumActualCards() {
        return this.mazzo.size();
    };

    
    /** 
     * Restituisce il numero di carte
     * del mazzo, non tenendo in considerazione delle carte pescate
     * 
     * @return int il numero delle carte totali
     */
    @Override
    public int getNumTotalCards() {
        return this.mazzo.size() + this.cartePescate;
    };

    
    
    /** 
     * Permette di pescare la carta presente in cima
     * del mazzo e restituirla
     * 
     * @return TCarta la carta pescata
     */
    @Override
    public TCarta draw() throws CartaException{
        if (this.mazzo.isEmpty()) {
            throw new CartaException();
        }
        TCarta carta = this.mazzo.remove(this.mazzo.size() - 1);
        this.cartePescate++;
        return carta;
    };
    /** 
     * Il metodo "shuffle" shuffle le carte dal mazzo utilizzando
     * Collections.shuffle presente nella classe Collections
     */
    @Override
    public void shuffle() {
        Collections.shuffle(this.mazzo);
    }

    
    /** 
     * Restituisce la TCarta dal mazzo passato un indice
     * 
     * @param index indice della carta da mostrare
     * @return TCarta la carta da mostrare
     * @throws CartaException
     */
    @Override
    public TCarta showCard(int index) throws CartaException{
        if (index < 0 || index >= this.mazzo.size()) {
            throw new CartaException();
        }
        return this.mazzo.get(index);
    }

    
    /** 
     * Restituisce la TCarta dal mazzo con dato indice 
     * rimuovendola dal mazzo stesso
     * 
     * @param index indice della carta da togliere
     * @return TCarta la carta da togliere
     */
    @Override
    public TCarta pickCard(int index) throws CartaException{
        if (index < 0 || index >= this.mazzo.size()) {
            throw new CartaException();
        }
        return this.mazzo.remove(index);
    }

    
    /** 
     * Overriding del metodo toString della classe Object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Mazzo [mazzo=" + this.mazzo + "]";
    }
}
