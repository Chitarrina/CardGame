package CardGame.Interfacce;

public interface IMazzoManager {
    
    public void shuffle();
    public int split();
    void ordinaMazzo();

    public Integer getMaxCarte();
    public void setMaxCarte();
    
    void pesca();
}
