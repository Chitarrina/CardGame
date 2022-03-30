package cardgame.libreria.model;

public abstract class Carta implements ICarta {

    private final int valore;

    public Carta(int valore) {
        this.valore = valore;
    }

    
    /** 
     * Restituisce il valore della carta
     * 
     * @return int il valore della carta
     */
    public int getValue() {
        return this.valore;
    }

    
    /** 
     * Overriding del metodo toString della classe Object
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Carta [" + this.valore + "]";
    }

    
    /** 
     * Overriding del metodo hashCode della classe Object
     * 
     * @return int l'hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + valore;
        return result;
    }

    
    /** 
     * Overriding del metodo equals della classe Object
     * 
     * due carte sono diverse se:
     *     L'oggetto passato rispetto a quello da considerare è null
     *     La classe dei due oggetti è diversa
     *     Il valore della carta è diverso
     * 
     * @param obj l'oggetto da confrontare
     * @return boolean vero se i due oggetti sono uguali, falso altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carta other = (Carta) obj;
        if (valore != other.valore)
            return false;
        return true;
    };
}
