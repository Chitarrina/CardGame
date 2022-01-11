package cardgame.carta;

public interface ICartaConSeme<S extends Enum<S>> extends ICarta {

    S getSemeCarta();
}
