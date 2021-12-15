package CardGame;

public class Napoletana {

    public enum Seme {
        BASTONI,
        COPPE,
        DENARI,
        SPADE;
    }
        
    public Seme seme;
    public int valore;

    

    public Napoletana(Seme seme, int valore){
        this.seme = seme;
        this.valore = valore;
    }
    
}

