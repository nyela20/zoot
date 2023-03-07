package zoot.arbre.declaration;

public class ConstanteBooleenne extends Constante {

    private final boolean cste;

    public ConstanteBooleenne(boolean bool, int n) {
        super(n);
        this.cste = bool;
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        if (cste) tomips.append("li $v0, 1\n");
        else tomips.append("li $v0, 0\n");
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
