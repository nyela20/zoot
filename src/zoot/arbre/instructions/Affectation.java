package zoot.arbre.instructions;

import zoot.arbre.declaration.Symbole;
import zoot.arbre.declaration.TDS;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Identifiant;
import zoot.exceptions.VariableIndefinieException;

public class Affectation extends Instruction{

    private final Identifiant identifiant;
    private final Expression exp;


    public Affectation(final Identifiant identifiant, final Expression exp,final int n) {
        super(n);
        this.identifiant = identifiant;
        this.exp = exp;
    }

    @Override
    public void verifier() throws VariableIndefinieException {
        //Variable indéfinie
        if(!TDS.getInstance().contains(identifiant.toString())){
            throw new VariableIndefinieException(this.noLigne, identifiant.toString());
        }
    }

    @Override
    public String toMIPS() {
        verifier();
        StringBuilder tomips = new StringBuilder();
        if(exp.estConstanteEntiere()) {
            tomips.append("\t#" + identifiant.toString() + " = " + exp.toString() + "\n" +
                    "\tli $v0, " + exp.toString() + "\n" +
                    "\tsw $v0, " + TDS.getInstance().identifier(identifiant.toString()).getDeplacement() + "($s7)");
        }
        return tomips.toString();
    }
}
