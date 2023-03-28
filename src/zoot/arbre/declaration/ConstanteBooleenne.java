package zoot.arbre.declaration;

public class ConstanteBooleenne extends Constante {

    private final boolean cste;

    /**
     *
     * @param b la valeur de la constante
     * @param n le numero de la ligne
     */
    public ConstanteBooleenne(boolean b, int n) {
        super(n);
        this.cste = b;
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        if (cste) tomips.append("\tli $v0, 1\n");
        else tomips.append("\tli $v0, 0\n");
        return tomips.toString();
    }

    @Override
    public Type getSymbole() {
        return Type.BOOLEEN;
    }

    @Override
    public String toString() {
        return cste ? "vrai" : "faux";
    }

}
