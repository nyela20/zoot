package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class AppelFonction extends Expression {

    private final String identifiant;

    public AppelFonction(String idf, int n) {
        super(n);
        this.identifiant = idf;
    }

    @Override
    public void verifier() {
        if (TDS.getInstance().identifier(new EntreeFonction(identifiant)) == null) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "La fonction " + identifiant + " n'est pas déclarée");
            return;
        }
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        tomips.append("\tjal " + ((SymboleFonction) TDS.getInstance().identifier(new EntreeFonction(identifiant))).getEtiquetteFonction() + "\n");
        return tomips.toString();
    }

    @Override
    public Type getSymbole() {
        return TDS.getInstance().identifier(new EntreeFonction(identifiant)).getType();
    }

    @Override
    public boolean estUneConstanteBooleenne() {
        return false;
    }

    @Override
    public boolean estUneConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estUneAppelDeFonction() {
        return true;
    }

    @Override
    public boolean estUnIdendifiant() {
        return false;
    }

    @Override
    public String toString() {
        return identifiant;
    }
}
