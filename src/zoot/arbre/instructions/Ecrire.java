package zoot.arbre.instructions;

import zoot.arbre.declaration.TDS;
import zoot.arbre.expressions.Expression;
import zoot.exceptions.VariableIndefinieException;

/**
 * @class Ecrire
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */
public class Ecrire extends Instruction {
    protected Expression exp ;
    private static final String ligne = "" + "\t#Saut de ligne\n" + "\tla $a0, saut\n" + "\tli $v0, 4\n" + "\tsyscall";

    /**
     * @brief Constructeur de la classe Ecrire
     * @param e une Expression
     * @param n le numéro de la ligne de l'expression dans le fichier .zoot
     */
    public Ecrire (Expression e, int n) {
        super(n) ;
        exp = e ;
    }

    /**
     * @brief Fonction qui analyse la sémantique de l'arbre abstrait construit.
     * @throws UnsupportedOperationException exception
     */
    @Override
    public void verifier() throws VariableIndefinieException {
        //Variable indéfini
        if(!TDS.getInstance().contains(exp.toString()) && exp.estIdf()){
            throw new VariableIndefinieException(this.noLigne, exp.toString());
        }
    }

    /**
     * @brief Fonction qui génére de code de l’arbre abstrait vérifié
     * @return le code de l'arbre abstrait vérifié
     */
    @Override
    public String toMIPS() {
        verifier();
        return (exp.toMIPS() + "\n" + ligne);
    }

}
