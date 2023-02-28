package zoot.arbre.declaration;

public class ConstanteEntiere extends Constante {

    private String cste;

    public ConstanteEntiere(String texte, int n) {
        super(n);
        this.cste = texte;
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        tomips.append("li $v0, " + cste + "\n");
        return tomips.toString();
    }

    @Override
    public Type getSymbole() {
        return Type.ENTIER;
    }

    @Override
    public String toString() {
        return cste;
    }

    @Override
    public boolean estUneConstanteBooleenne() {
        return false;
    }

    @Override
    public boolean estUneConstanteEntiere() {
        return true;
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
