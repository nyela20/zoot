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
        }
    }

    @Override
    public String toMIPS() {
        return "\tjal " + ((SymboleFonction) TDS.getInstance().identifier(new EntreeFonction(identifiant))).getEtiquetteFonction() + "\n";
    }

    @Override
    public Type getSymbole() {
        return TDS.getInstance().identifier(new EntreeFonction(identifiant)).getType();
    }

    @Override
    public String toString() {
        return identifiant;
    }
}
