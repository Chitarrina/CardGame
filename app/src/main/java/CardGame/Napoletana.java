package CardGame;

public class Napoletana {

    public enum Seme {
        BASTONI,
        COPPE,
        DENARI,
        SPADE;
    }
        
    public Seme seme;
    public Integer valore;

    

    public Napoletana(Seme seme, Integer valore){
        this.seme = seme;
        this.valore = valore;
    }
    
}

