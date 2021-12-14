package CardGame;

import CardGame.Interfacce.ICarta;

public class Carta<T> implements ICarta<T>{
    
    public T seme;
    public T valore;

    public String nome;


    public void setSeme(T seme){
        this.seme = seme;
    }
    public void setValore(T valore){
        this.valore = valore;
    }

    public void setNome() {
        // TODO Auto-generated method stub
        
    }

    

    public Carta(Napoletana napoletana){
    }
    public Carta() {
    }

   
    
    
}
