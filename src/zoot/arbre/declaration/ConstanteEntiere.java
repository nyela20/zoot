package zoot.arbre.declaration;

public class ConstanteEntiere extends Constante {

    private final String cste;

    /**
     *
     * @param texte la valeur de la constante
     * @param n le numero de la ligne
     */
    public ConstanteEntiere(String texte, int n) {
        super(n);
        this.cste = texte;
    }

    @Override
    public String toMIPS() {
        return "\tli $v0, " + cste + "\n";
    }

    @Override
    public Type getSymbole() {
        return Type.ENTIER;
    }

    @Override
    public String toString() {
        return cste;
    }

}
