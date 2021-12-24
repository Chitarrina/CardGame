package CardGame.GestioneGioco;

import CardGame.Giocatore.Giocatore;

public interface IGiocoManager{

    Integer getPunteggioVittoria();
    
    Giocatore getPrimoGiocatore();
    
    Giocatore getTurnoGiocatore();


    
   

}
