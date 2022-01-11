package cardgame.classifica;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ClassificaSemplice implements IClassifica {

    private HashMap<String, Integer> classifica;

    public ClassificaSemplice(Collection<String> giocatori) {
        this.classifica = new HashMap<>();
        for (String s : giocatori) {
            this.classifica.put(s, 0);
        }
    }

    public String getVincitore() {
        return Collections.max(this.classifica.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public void aggiornaPunteggio(String giocatore, int punteggio) {
        this.classifica.put(giocatore, punteggio);
    }

    public int getPunteggio(String giocatore) {
        return this.classifica.get(giocatore);
    }
}
