package cardgame.libreria.model;

public interface ICartaConSeme<S extends Enum<S>> extends ICarta {
    public S getSeed();
}
