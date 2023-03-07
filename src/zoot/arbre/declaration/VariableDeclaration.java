package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class VariableDeclaration {
    private final EntreeVariable entreeVariable;
    private final SymboleVariable symboleVariable;
    private final int n; //numero de ligne

    public VariableDeclaration(EntreeVariable entreeVariable, SymboleVariable symboleVariable, int n) {
        this.entreeVariable = entreeVariable;
        this.symboleVariable = symboleVariable;
        this.n = n;
    }

    public void verifier() {
        if (!TDS.getInstance().ajouterEntreeSymbole(entreeVariable, symboleVariable)) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(n, "Double déclaration de la variable " + entreeVariable.identifiant);
        }
    }

    public Expression.Type getType() {
        return symboleVariable.getType();
    }
}