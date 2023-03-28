package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class VariableDeclaration {
    private final EntreeVariable entreeVariable;
    private final SymboleVariable symboleVariable;
    private final int n; //numero de ligne

    /**
     *
     * @param entreeVariable Instance d'une entree de variable
     * @param symboleVariable Instance du symbole de la variable
     * @param n le numero de ligne
     */
    public VariableDeclaration(EntreeVariable entreeVariable, SymboleVariable symboleVariable, int n) {
        this.entreeVariable = entreeVariable;
        this.symboleVariable = symboleVariable;
        this.n = n;
    }
    public void verifier(boolean isparam) {
        if (!TDS.getInstance().ajouterEntreeEtSymbole(entreeVariable, symboleVariable,isparam))  AnalyseSemantiqueException.raiseAnalyseSemantiqueException(n, "Double déclaration de la variable " + entreeVariable.identifiant);
    }
    public Expression.Type getType() {
        return symboleVariable.getType();
    }
}