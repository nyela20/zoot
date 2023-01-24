package zoot.arbre.instructions;

import zoot.arbre.ArbreAbstrait;

/**
 * @class Instruction
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */
public abstract class Instruction extends ArbreAbstrait {

    /**
     * @brief Constructeur de la classe Instruction
     * @param n le numéro de la ligne de l'instruction dans le fichier .zoot
     */
    protected Instruction(int n) {
        super(n);
    }

}
