package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class VariableDeclaration {
    private EntreeVariable entreeVariable;
    private SymboleVariable symboleVariable;
    private int n; //numero de ligne

    public VariableDeclaration(EntreeVariable entreeVariable, SymboleVariable symboleVariable, int n) {
        this.entreeVariable = entreeVariable;
        this.symboleVariable = symboleVariable;
        this.n = n;
    }

    public void verifier() {
        if (!TDS.getInstance().ajouterSymbole(entreeVariable, symboleVariable)) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(n, "Double déclaration de la variable " + entreeVariable.identifiant);
        }
    }

    public Expression.Type getType() {
        return symboleVariable.getType();
    }
}