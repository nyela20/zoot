package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

import java.util.ArrayList;

public class FonctionDeclaration {

    private final Fonction fonction;
    private final Expression.Type symboleRetour;
    private int numLigne;
    private final int deplacementBaseFonction;

    public FonctionDeclaration(Fonction fonction, Expression.Type symboleRetour, int numLigne) {
        this.fonction = fonction;
        this.symboleRetour = symboleRetour;
        this.numLigne = numLigne;
        this.deplacementBaseFonction = 0;
    }

    public Fonction verifier() {
        ArrayList<Expression.Type> symboles = new ArrayList<Expression.Type>();
        if(!TDS.getInstance().ajouterEntreeEtSymbole(new EntreeFonction(fonction.getIdentifiant()), new SymboleFonction(symboleRetour))){
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(numLigne, " : Double déclaration de la fonction " + fonction.getIdentifiant());
        }
        TDS.getInstance().sortirBloc();
        return fonction;
    }

}
