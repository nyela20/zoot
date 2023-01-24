package zoot.arbre;

/**
 * @class ArbreAbstrait
 * @abstract
 * @brief ArbreAbstrait
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */
public abstract class ArbreAbstrait {
    
    // numéro de ligne du début de l'instruction
    protected int noLigne ;

    /**
     * @brief Constructeur de la classe ArbreAbstrait
     * @param n le numéro de la ligne de l'arbre abstrait dans le fichier .zoot
     */
    protected ArbreAbstrait(int n) {
        noLigne = n ;
    }

    /**
     * @brief Fonction qui retourne le numéro de la ligne d'une classe de l'arbre abstrait
     * @return le numéro de ligne d'une classe de l'arbre abstrait
     */
    public int getNoLigne() {
            return noLigne ;
    }

    /**
     * @brief Fonction qui analyse la sémantique de l'arbre abstrait construit.
     * @throws UnsupportedOperationException exception
     */
    public abstract void verifier() ;

    /**
     * @brief Fonction qui génére de code de l’arbre abstrait vérifié
     * @return le code de l'arbre abstrait vérifié
     */
    public abstract String toMIPS();

}
