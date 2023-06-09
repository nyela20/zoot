package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class Addition extends Binaire{

    /**
     * @param n le numéro de la ligne
     */
    public Addition(Expression opGauche, Expression opDroite, int n) {
        super(opGauche, opDroite, n);
    }

    @Override
    public void verifier() {
        super.verifier();
        if(operandeDroite.getSymbole() != Type.ENTIER || operandeGauche.getSymbole() != Type.ENTIER) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Addition de deux expression qui n'ont pas le même type");
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        tomips.append(operandeGauche.toMIPS());
        tomips.append("\tsw $v0, ($sp)\n");
        tomips.append("\taddi $sp, $sp, -4\n");
        tomips.append(operandeDroite.toMIPS());
        tomips.append("\taddi $sp, $sp, 4\n");
        tomips.append("\tlw $v1, ($sp)\n");
        tomips.append("\tadd $v0, $v1, $v0\t#Addition des deux operandes\n");
        return tomips.toString();
    }

    @Override
    public Type getSymbole() {
        return Type.ENTIER;
    }
}
