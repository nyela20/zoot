package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;

public class Retourner extends Instruction {
    protected final Expression exp;
    public Retourner(Expression exp, int n){
        super(n);
        this.exp = exp;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "\t#retourner";
    }
}
