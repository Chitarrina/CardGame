package cardgame.mazzo;

import java.util.Collection;
import java.util.Optional;

import cardgame.carta.ICarta;

public class Mazzo<T extends ICarta> implements IMazzo<T> {

    private Collection<T> mazzo;
    private int cartePescate;

    public Mazzo(Collection<T> carte) {
        this.mazzo = carte;
        this.cartePescate = 0;
    }

    public int getCarteTotali() {
        return this.mazzo.size();
    };

    public int getCarteRimanenti() {
        return this.mazzo.size() - this.cartePescate;
    };

    public T pesca() {
        this.cartePescate++;
        Optional<T> optionalCartaPescata = mazzo.stream().findFirst();
        if (optionalCartaPescata.isPresent()) {
            return optionalCartaPescata.get();
        } else {
            // TODO: gestire caso in cui il mazzo non ha più carte
            return null;
        }
    };

    public void shuffle() {
        // TODO: implementare
        // es. se al posto di Collection<T> mazzo, si usasse
        // List<>
    }

    @Override
    public String toString() {
        return "Mazzo [mazzo=" + mazzo + "]";
    }
}
