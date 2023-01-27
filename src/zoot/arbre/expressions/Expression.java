package zoot.arbre.expressions;

import zoot.arbre.ArbreAbstrait;

/**
 * @class Expression
 * @brief Expression
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */
public abstract class Expression extends ArbreAbstrait {

    /**
     * @brief Constructeur de la classe Expression
     * @param n numéro de ligne de l'expression dans le fichier .zoot
     */
    protected Expression(int n) {
        super(n) ;
    }

    public abstract boolean estConstanteEntiere();

    public abstract boolean estConstanteBooleenne();


}
