package zoot.arbre.expressions;

/**
 * @class ConstanteEntiere
 * @brief feuille de l'arbre abstrait Constante entière.
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */
public class ConstanteEntiere extends Constante {

    /**
     * @brief Constructeur de la clase ConstanteEntiere
     * @param texte représentation .asciiz de la constante.
     * @param n le numéro de ligne de la constante dans le fichier .zoot.
     */
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public boolean estConstanteEntiere() {
        return true;
    }

    @Override
    public boolean estConstanteBooleenne() {
        return false;
    }

    @Override
    public boolean estIdf() {
        return false;
    }

    /**
     * @brief Fonction qui génére de code de l’arbre abstrait vérifié
     * @return le code de l'arbre abstrait vérifié
     */
    @Override
    public String toMIPS() {
        return "\t#ecrire " + this.toString() + "\n" +
                "\tli $a0, " + this.toString() + "\n" +
                "\tli $v0 , 1 " + "\n" +
                "\tsyscall";
    }
}
