package zoot.arbre.instructions;

import zoot.arbre.declaration.Symbole;
import zoot.arbre.expressions.Expression;

public class Affection extends Instruction{

    private final String identifiant;
    private final Expression exp;

    private final Symbole symbole;


    /**
     * @param n           le numéro de la ligne de l'instruction dans le fichier .zoot
     * @param identifiant
     * @param exp
     * @param symbole
     * @brief Constructeur de la classe Instruction
     */
    protected Affection(String identifiant, Expression exp, Symbole symbole, int n) {
        super(n);
        this.identifiant = identifiant;
        this.exp = exp;
        this.symbole = symbole;
    }

    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    @Override
    public String toMIPS() {
        return null;
    }
}
