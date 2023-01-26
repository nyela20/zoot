package zoot.arbre.instructions;

import zoot.arbre.declaration.Symbole;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Identifiant;

public class Affectation extends Instruction{

    private final Identifiant identifiant;
    private final Expression exp;


    public Affectation(final Identifiant identifiant, final Expression exp,final int n) {
        super(n);
        this.identifiant = identifiant;
        this.exp = exp;
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
