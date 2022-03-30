package cardgame.libreria.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import cardgame.libreria.model.concrete.ConcreteCartaConSeme;
import cardgame.libreria.model.concrete.ConcreteSeme;

public class CartaConSemeTest {

    @Test
    public void shouldgetSeed() {
        ConcreteCartaConSeme cartaConSeme = new ConcreteCartaConSeme(3, ConcreteSeme.SEME_A);
        assertTrue(cartaConSeme.getSeed() == ConcreteSeme.SEME_A);
    }

    @Test
    public void shouldgetValue() {
        ConcreteCartaConSeme cartaConSeme = new ConcreteCartaConSeme(3, ConcreteSeme.SEME_A);
        assertTrue(cartaConSeme.getValue() == 3);
    }
}
