package cardgame.classifica;

public interface IClassifica {

    String getVincitore();

    void aggiornaPunteggio(String giocatore, int punteggio);

    int getPunteggio(String giocatore);
}
