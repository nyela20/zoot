package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

import java.util.ArrayList;

public class AppelFonction extends Expression {

    private final String identifiant;

    private final ArrayList<Expression> params;

    /**
     *
     * @param idf Le nom de la fonction
     * @param params Les paramètres de la fonctions
     * @param n le nombre de paramètres
     */
    public AppelFonction(String idf, ArrayList<Expression> params, int n) {
        super(n);
        this.identifiant = idf;
        this.params = params;
    }


    @Override
    public void verifier() {
        if (TDS.getInstance().identifier(new EntreeFonction(identifiant, params.size())) == null) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "La fonction " + identifiant + " n'est pas déclarée");
        }
    }

    @Override
    public String toMIPS() {
        StringBuilder empilementParametres = new StringBuilder();

        for (int i = 0; i< params.size(); i++) { //On empile les paramètres
            empilementParametres
                    .append(params.get( params.size()-(i+1) ).toMIPS())
                    .append("\tsw $v0, ($sp)\n")
                    .append("\taddi $sp, $sp, -4\n");
        }

        return empilementParametres
                .append("\tjal " + ((SymboleFonction)TDS.getInstance().identifier(new EntreeFonction(identifiant, params.size()))).getEtiquetteFonction() + "\n") //On appel ensuite la fonction
                +"";
    }

    @Override
    public Type getSymbole() {
        return TDS.getInstance().identifier(new EntreeFonction(identifiant, params.size())).getType();
    }

    @Override
    public String toString() {
        return identifiant;
    }
}
