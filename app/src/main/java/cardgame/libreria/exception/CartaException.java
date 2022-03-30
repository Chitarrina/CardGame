package cardgame.libreria.exception;

public class CartaException extends Exception{
    public CartaException(){
        super("carta non consentita");
    }
}