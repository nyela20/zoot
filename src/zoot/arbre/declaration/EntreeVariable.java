package zoot.arbre.declaration;

public class EntreeVariable extends Entree {

    public EntreeVariable(String nom) {
        super(nom);
    }

    @Override
    public Symbole getSymbole() {
        return Symbole.VARIABLE;
    }

    @Override
    public String toString() {
        return "variable " + identifiant;
    }
}
