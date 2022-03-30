package cardgame.libreria.model;

import cardgame.libreria.exception.CartaException;
import cardgame.libreria.model.concrete.ConcreteCartaConSeme;
import cardgame.libreria.model.concrete.ConcreteSeme;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class MazzoTest {

    @Test
    public void shouldGetNumTotalCards() {
        ConcreteCartaConSeme cartaConSeme1 = new ConcreteCartaConSeme(1, ConcreteSeme.SEME_A);
        ConcreteCartaConSeme cartaConSeme2 = new ConcreteCartaConSeme(2, ConcreteSeme.SEME_A);

        Stack<ConcreteCartaConSeme> carte = new Stack<ConcreteCartaConSeme>();

        carte.push(cartaConSeme1);
        carte.push(cartaConSeme2);

        Mazzo<ConcreteCartaConSeme> mazzo = new Mazzo<ConcreteCartaConSeme>(carte);

        assertTrue(mazzo.getNumTotalCards() == 2);
    }


    @Test
    public void shouldDraw() throws CartaException{
        ConcreteCartaConSeme cartaConSeme1 = new ConcreteCartaConSeme(1, ConcreteSeme.SEME_A);
        ConcreteCartaConSeme cartaConSeme2 = new ConcreteCartaConSeme(2, ConcreteSeme.SEME_A);

        Stack<ConcreteCartaConSeme> carte = new Stack<ConcreteCartaConSeme>();
        carte.push(cartaConSeme1);
        carte.push(cartaConSeme2);

        Mazzo<ConcreteCartaConSeme> mazzo = new Mazzo<ConcreteCartaConSeme>(carte);

        mazzo.draw();
        assertTrue(mazzo.getNumTotalCards() != mazzo.getNumActualCards());
    }

    public void shouldThrowCartaExceptionWhenDrawNullCard(){
        Stack<ConcreteCartaConSeme> carte = new Stack<ConcreteCartaConSeme>();
        Mazzo<ConcreteCartaConSeme> mazzo = new Mazzo<ConcreteCartaConSeme>(carte);

        assertThrows(CartaException.class,() -> mazzo.draw());
    }
    @Test
    public void shouldgetNumActualCardsAndDraw() throws CartaException {
        ConcreteCartaConSeme cartaConSeme1 = new ConcreteCartaConSeme(1, ConcreteSeme.SEME_A);
        ConcreteCartaConSeme cartaConSeme2 = new ConcreteCartaConSeme(2, ConcreteSeme.SEME_A);

        Stack<ConcreteCartaConSeme> carte = new Stack<ConcreteCartaConSeme>();

        carte.push(cartaConSeme1);
        carte.push(cartaConSeme2);

        Mazzo<ConcreteCartaConSeme> mazzo = new Mazzo<ConcreteCartaConSeme>(carte);

        assertTrue(mazzo.getNumActualCards() == 2);

        mazzo.draw();

        assertTrue(mazzo.getNumActualCards() == 1);
    }

}
