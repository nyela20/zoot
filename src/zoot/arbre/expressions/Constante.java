package zoot.arbre.expressions;

/**
 * @class Constante
 * @brief feuille de l'arbre abstrait Constante.
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */
public abstract class Constante extends Expression {

    protected String cste ;

    /**
     * @brief Constructeur de la classe Constante.
     * @param texte représentation .asciiz de la constante.
     * @param n le numéro de ligne de la constante dans le fichier .zoot.
     */
    protected Constante(String texte, int n) {
        super(n) ;
        cste = texte ;
    }

    /**
     * @brief Fonction qui analyse la sémantique de l'arbre abstrait construit.
     * @throws UnsupportedOperationException exception
     */
    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    /**
     * @brief Fonction qui retourne la représentation .asciiz de la constante
     * @return la constante sous format .asciiz
     */
    @Override
    public String toString() {
        return cste ;
    }

    protected String toStrBool(String valeur){
        if(valeur.compareTo("vrai") == 0) return "strvrai";
        return "strfaux";
    }




}
