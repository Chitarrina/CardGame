package cardgame.libreria.model;

public abstract class CartaConSeme<Seed extends Enum<Seed>> extends Carta implements ICartaConSeme<Seed> {

    private final Seed seme;

    public CartaConSeme(int valore, Seed seme) {
        //preso dalla classe Carta essendo CartaConSeme
        //figlia della classe Carta
        super(valore);
        this.seme = seme;
    }


    
    /** 
     * Restituisce il seme della carta di tipo Seed
     * 
     * @return Seed il seme della carta
     */
    @Override
    public Seed getSeed() {
        return this.seme;
    }

    
    /** 
     * Overriding del metodo toString dalla classe Object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "CartaConSeme [" + this.getValue() + " di " + this.seme + "]";
    }

    
    /** 
     * Overriding del metodo hashCode dalla classe Object
     * 
     * @return int l'hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + getValue();
        result = prime * result + ((seme == null) ? 0 : seme.hashCode());
        return result;
    }

    
    /** 
     * Overriding del metodo equals dalla classe Object
     * 
     * due carte con seme sono diverse se:
     *     L'oggetto passato rispetto a quello da considerare è null
     *     La classe dei due oggetti è diversa
     *     Il valore della carta è diverso
     *     I semi sono diversi
     * 
     * @param obj l'oggetto da confrontare
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        CartaConSeme<Seed> other = (CartaConSeme<Seed>) obj;
        if (getValue() != other.getValue())
            return false;
        if (seme == null) {
            if (other.seme != null)
                return false;
        } else if (!seme.equals(other.seme))
            return false;
        return true;
    }
}
