package zoot.arbre.declaration;

public class EntreeVariable extends Entree{
    public EntreeVariable(String nomVariable) {
        super(nomVariable);
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }
}
