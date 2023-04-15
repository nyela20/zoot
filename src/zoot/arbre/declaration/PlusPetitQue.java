package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class PlusPetitQue extends Binaire{

    public PlusPetitQue(Expression exp1, Expression exp2, int n) {
        super(exp1, exp2, n);
    }

    @Override
    public void verifier() {
        super.verifier();
        if(operandeDroite.getSymbole() == Type.UNDEFINED) return ;
        if(operandeDroite.getSymbole() == Type.UNDEFINED) return;
        if(operandeDroite.getSymbole() != Type.ENTIER) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Les conditons d arrets ne sont pas type entiere");
        if(operandeDroite.getSymbole() != Type.ENTIER) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Les conditons d arrets ne sont pas type entiere");
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        tomips.append(operandeGauche.toMIPS());
        tomips.append("\tsw $v0, ($sp)\n");
        tomips.append("\taddi $sp, $sp, -4\n");
        tomips.append(operandeDroite.toMIPS());
        tomips.append("\taddi $sp, $sp, -4\n");
        tomips.append("\tlw $v1, ($sp)\n");
        tomips.append("\tslt $v0, $v1, $v0\n");
        return tomips.toString();
    }

    @Override
    public Type getSymbole() {
        return null;
    }
}
