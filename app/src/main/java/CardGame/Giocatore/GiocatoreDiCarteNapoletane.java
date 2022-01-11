package cardgame.giocatore;

import cardgame.carta.CartaNapoletana;

public class GiocatoreDiCarteNapoletane implements IGiocatore<CartaNapoletana> {

    private String nome;

    public GiocatoreDiCarteNapoletane(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public CartaNapoletana getMossa() {
        // TODO: il giocatore dovrebbe avere il modo di vedere il tavolo da gioco
        // si potrebbe seguire il pattern MVC e far accedere il giocatore alla
        // View del gioco
        return null;
    }

    @Override
    public String toString() {
        return "Giocatore [nome=" + nome + "]";
    }
}
