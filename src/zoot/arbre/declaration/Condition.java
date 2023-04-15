package zoot.arbre.declaration;

import zoot.arbre.instructions.Instruction;

public class Condition extends Instruction {

    public Condition(int n) {
        super(n);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "";
    }
}
