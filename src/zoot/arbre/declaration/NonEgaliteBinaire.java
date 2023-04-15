package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class NonEgaliteBinaire extends Binaire{
    private String etiquette1;
    private String etiquette2;

    public NonEgaliteBinaire(Expression opGauche, Expression opDroite, int n) {
        super(opGauche, opDroite, n);
    }

    @Override
    public void verifier(){
        super.verifier();
        if(operandeDroite.getSymbole() == Type.UNDEFINED) return ;
        if(operandeDroite.getSymbole() == Type.UNDEFINED) return ;
        if(operandeDroite.getSymbole() != operandeGauche.getSymbole()) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Expression de type differents !");
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        this.etiquette1 = TDS.getInstance().generationNouvelleEtiquette();
        this.etiquette2 = TDS.getInstance().generationNouvelleEtiquette();
        tomips.append("\t#Operante gauche\n");
        tomips.append(operandeGauche.toMIPS());
        tomips.append("\tsw $v0, ($sp) \t #Empilement\n");
        tomips.append("\taddi $sp, $sp, -4\n");
        tomips.append("\t#Operante droite\n");
        tomips.append(operandeDroite.toMIPS());
        tomips.append("\taddi $sp, $sp, 4\n");
        tomips.append("\tlw  $v1, ($sp)\n");
        tomips.append("\tbne $v1, $v0, " + etiquette1 + "\n");
        tomips.append("\tli $v0, 0\n");
        tomips.append("\tj " + etiquette2 + "\n");
        tomips.append(etiquette1 + ":\n");
        tomips.append("\tli $v0, 1\n");
        tomips.append(etiquette2 + ":\n");
        return tomips.toString();
    }

    @Override
    public Type getSymbole() {
        return Expression.Type.BOOLEEN;
    }
}
