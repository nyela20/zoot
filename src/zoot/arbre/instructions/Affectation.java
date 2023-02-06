package zoot.arbre.instructions;

import zoot.arbre.declaration.TDS;
import zoot.arbre.expressions.Expression;
import zoot.arbre.expressions.Identifiant;
import zoot.exceptions.MauvaisAffectionTypeException;
import zoot.exceptions.VariableIndefinieException;

public class Affectation extends Instruction {

    private final Identifiant identifiant;
    private final Expression exp;


    public Affectation(final Identifiant identifiant, final Expression exp, final int n) {
        super(n);
        this.identifiant = identifiant;
        this.exp = exp;
    }

    @Override
    public void verifier() throws VariableIndefinieException {
        //Variable indéfinie
        if (!TDS.getInstance().contains(identifiant.toString())) {
            throw new VariableIndefinieException(this.noLigne, identifiant.toString());
        }
        //Type différent lors d'une affectation
        if ((TDS.getInstance().identifier(this.identifiant.toString()).getSymbole().compareTo("entier") == 0) && exp.estConstanteBooleenne()) {
            throw new MauvaisAffectionTypeException(this.noLigne, identifiant.toString());
        }
        if ((TDS.getInstance().identifier(this.identifiant.toString()).getSymbole().compareTo("booleen") == 0) && exp.estConstanteEntiere()) {
            throw new MauvaisAffectionTypeException(this.noLigne, identifiant.toString());
        }
        if(exp.estIdentifiant()) {
            if ((TDS.getInstance().identifier(this.exp.toString()).getSymbole().compareTo(TDS.getInstance().identifier(this.identifiant.toString()).getSymbole()) != 0)) {
                throw new MauvaisAffectionTypeException(this.noLigne, identifiant.toString());
            }
        }
    }

    @Override
    public String toMIPS() {
        verifier();
        StringBuilder tomips = new StringBuilder();
        if (exp.estConstanteEntiere()) {
            tomips.append("\t#" + identifiant.toString() + " = " + exp.toString() + "\n" +
                    "\tli $v0, " + exp.toString() + "\n" +
                    "\tsw $v0, " + TDS.getInstance().identifier(identifiant.toString()).getDeplacement() + "($s7)");
        } else if (exp.estConstanteBooleenne()) {
            tomips.append("\t#" + identifiant.toString() + " = " + exp.toString() + "\n" +
                    "\tla $v0, " + exp.toString() + "\n" +
                    "\tsw $v0, " + TDS.getInstance().identifier(identifiant.toString()).getDeplacement() + "($s7)");
        } else if (exp.estIdentifiant()) {
            if (TDS.getInstance().identifier(identifiant.toString()).getSymbole().compareTo("entier") == 0) {
                tomips.append("\t#" + identifiant.toString() + " = " + exp.toString() + "\n" +
                        "\tlw $v0," + TDS.getInstance().identifier(exp.toString()).getDeplacement() + "($s7)\n" +
                        "\tsw $v0, " + TDS.getInstance().identifier(identifiant.toString()).getDeplacement() + "($s7)");
            } else if ((TDS.getInstance().identifier(identifiant.toString()).getSymbole().compareTo("booleen") == 0)) {
                // A REMPLIR

            }
        }
        return tomips.toString();
    }
}
