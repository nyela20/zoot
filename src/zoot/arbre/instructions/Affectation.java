package zoot.arbre.instructions;

import zoot.arbre.declaration.Expression;
import zoot.arbre.declaration.Identifiant;
import zoot.exceptions.AnalyseSemantiqueException;

public class Affectation extends Instruction {
    private final Identifiant identifiant;
    private final Expression exp;

    public Affectation(Identifiant identifiant, Expression exp, int n) {
        super(n);
        this.exp = exp;
        this.identifiant = identifiant;
    }
    @Override
    public String toMIPS() {
        StringBuilder tomips1 = new StringBuilder();
        tomips1.append("\tsw $a0, ($sp)\n");
        tomips1.append("\taddi $sp, $sp, -4\n" );
        StringBuilder tomips2 = new StringBuilder();

        tomips2.append(identifiant.getBaseEtDeplacement()
                + tomips1);
        tomips2.append(exp.toMIPS());

        tomips2.append("\taddi $sp, $sp, 4\n");
        tomips2.append("\tlw $a0, ($sp)\n");
        tomips2.append("\tsw $v0, ($a0)\n");

        return tomips2.toString();
    }
    @Override
    public void verifier() {
        identifiant.verifier();
        exp.verifier();
        if(identifiant.getSymbole() == Expression.Type.UNDEFINED || exp.getSymbole() == Expression.Type.UNDEFINED) return;
        if (identifiant.getSymbole() != exp.getSymbole()) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "L\'affectation " + identifiant + "=" + exp.toString() + " ne peux pas être effectué, car le type de la variable (" + identifiant + ") n'est pas de même type que l'expression ("+ exp.toString() +")");
    }
}
