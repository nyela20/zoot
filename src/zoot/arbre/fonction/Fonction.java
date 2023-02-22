package zoot.arbre.fonction;

import zoot.arbre.ArbreAbstrait;

public class Fonction extends ArbreAbstrait {

    /**
     * @param n le numéro de la ligne de l'arbre abstrait dans le fichier .zoot
     * @brief Constructeur de la classe ArbreAbstrait
     */
    protected Fonction(int n) {
        super(n);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
