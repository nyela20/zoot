package zoot.arbre.declaration;

public class ConstanteBooleenne extends Constante {

    private boolean cste;

    public ConstanteBooleenne(boolean bool, int n) {
        super(n);
        this.cste = bool;
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

    @Override
    public boolean estUneConstanteBooleenne() {
        return true;
    }

    @Override
    public boolean estUneConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estUneAppelDeFonction() {
        return false;
    }

    @Override
    public boolean estUnIdendifiant() {
        return false;
    }
}
