package zoot.arbre.instructions;

import zoot.arbre.declaration.Expression;
import zoot.exceptions.AnalyseSemantiqueException;
import zoot.arbre.declaration.TDS;

public class Retourne extends Instruction {
    private Expression exp;

    public Retourne(Expression exp, int n) {
        super(n);
        this.exp = exp;
    }

    @Override
    public void verifier() {
        if (TDS.getInstance().getSymboleBloc() == null) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Aucun retour de fonction pour ce bloc");
            return;
        }
        exp.verifier();
        if (exp.getSymbole() == Expression.Type.UNDEFINED) return;
        if (TDS.getInstance().getSymboleBloc().getType() != exp.getSymbole())
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Types incompatibles : " + exp.toString() + " de type " + exp.getSymbole() + ", type retrouvé : " + TDS.getInstance().getSymboleBloc().getType());
    }

    @Override
    public String toMIPS() {
        StringBuilder tompis = new StringBuilder();
        tompis.append("\t#Mettre à jour le sommet de la pile et $(s7)\n");
        tompis.append("\tlw $ra, 8($s7)\n");
        tompis.append("\tmove $sp, $s7\n");
        tompis.append("\taddi $sp, $sp, 0\n");
        tompis.append("\tlw $s7, 4($s7)\n");
        tompis.append("\tjr $ra\n");
        return exp.toMIPS() + tompis;
    }

}