package cardgame.libreria.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cardgame.libreria.model.concrete.ConcreteCarta;

public class CartaTest {

    @Test
    public void shouldgetValue() {
        ConcreteCarta carta = new ConcreteCarta(2);
        assertTrue(carta.getValue() == 2);
    }
}