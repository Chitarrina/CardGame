package cardgame.libreria.giocatore;

import cardgame.libreria.model.ICarta;

public abstract class Giocatore<K extends ICarta> implements IGiocatore<K> {

    private String nome;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    
    /** 
     * Il metodo restituisce il nome del giocatore
     * 
     * @return String il nome del giocatore
     */
    public String getNome() {
        return this.nome;
    }

    
    /** 
     * Overriding del metodo toString della classe Object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Giocatore [nome=" + nome + "]";
    }
}
