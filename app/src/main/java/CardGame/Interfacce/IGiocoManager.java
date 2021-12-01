package CardGame.Interfacce;

import CardGame.Giocatore;

public interface IGiocoManager{
    public Integer getPunteggioVittoria();
    public void setPunteggioVittoria();

    public Giocatore getPrimoGiocatore();
    public void setPrimoGiocatore();

    public Giocatore getTurnoGiocatore();
    public void setTurnoGiocatore();

}
