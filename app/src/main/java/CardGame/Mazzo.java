package CardGame;


import CardGame.Interfacce.IMazzo;

public class Mazzo implements IMazzo<Carta>{
  

    //array di carte (da capire quali strutture dati usare)
    private Carta carta[];
    private Integer numeroCarte;

    @Override
    public boolean isOrdinato() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Integer numeroCarte() {
        // TODO Auto-generated method stub
        return numeroCarte;
    }
    
    public Mazzo(){
        
    }

    
}
