package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FonctionDeclaration {

    private final Fonction fonction;
    private final Expression.Type symboleRetour;
    private int numLigne;
    private final int deplacementBaseFonction;
    private ArrayList<VariableDeclaration> parms;
    private ArrayList<VariableDeclaration> vars;

    /**
     *
     * @param fonction L'instance de la fonction
     * @param symboleRetour Le type de retour de la fonction
     * @param numLigne le numero de ligne de la fonction
     */
    public FonctionDeclaration(Fonction fonction, Expression.Type symboleRetour, int numLigne) {
        this.fonction = fonction;
        this.symboleRetour = symboleRetour;
        this.numLigne = numLigne;
        this.deplacementBaseFonction = 0;
    }

    public FonctionDeclaration(Fonction fonction, Expression.Type symboleRetour, ArrayList<VariableDeclaration> params, ArrayList<VariableDeclaration> vars, int ligne){
        this.fonction = fonction;
        this.symboleRetour = symboleRetour;
        this.deplacementBaseFonction = 0;
        this.parms = params;
        this.vars = vars;
    }

    public Fonction verifier() {
        ArrayList<Expression.Type> symboles = new ArrayList<Expression.Type>();
        if(!TDS.getInstance().ajouterEntreeEtSymbole(new EntreeFonction(fonction.getIdentifiant(), parms.size()), new SymboleFonction(symboleRetour))){
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(numLigne, " : Double déclaration de la fonction " + fonction.getIdentifiant());
        }
        for(VariableDeclaration p : parms) {
            symboles.add(p.getType());
        }
        for(VariableDeclaration p : parms ){
            p.verifier(true);
        }
        for(VariableDeclaration vd : vars){
            vd.verifier(false);
        }
        TDS.getInstance().sortirBloc();
        return fonction;
    }

}
