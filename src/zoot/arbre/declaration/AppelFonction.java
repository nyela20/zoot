package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppelFonction extends Expression {

    private final String identifiant;

    private ArrayList<Expression> params;

    public AppelFonction(String idf, ArrayList<Expression> params, int n) {
        super(n);
        this.identifiant = idf;
        this.params = params;
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
