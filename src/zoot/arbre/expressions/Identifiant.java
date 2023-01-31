package zoot.arbre.expressions;

import zoot.arbre.declaration.Symbole;
import zoot.arbre.declaration.TDS;

public class Identifiant extends Constante{

    public Identifiant(String texte, int n){
        super(texte, n);
    }


    @Override
    public boolean estConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estConstanteBooleenne() {
        return false;
    }

    @Override
    public boolean estIdentifiant() {
        return true;
    }

    @Override
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        Symbole symbole = TDS.getInstance().identifier(this.cste);
        //Si l'identifiant est un entier.
        if(symbole.getSymbole().compareTo("entier") == 0) {
            tomips.append("\t#ecrire " + this.cste + "\n");
            tomips.append("\tlw $a0, " + symbole.getDeplacement() + "($s7)\n");
            tomips.append("\tli $v0, 1\n");
            tomips.append("\tsyscall");
        }else if(symbole.getSymbole().compareTo("booleen") == 0){
            int conditionIndex = TDS.getInstance().getConditionIndex();
            tomips.append("\t#ecrire " + this.cste + "\n");
            tomips.append("\t#la $t0, faux\n");
            tomips.append("\tlw $a0, " + symbole.getDeplacement() + "($s7)\n");
            tomips.append("\tbeq $t0,$a0, Sinon" + conditionIndex + " \n");
            tomips.append("\tla $a0, strvrai\n");
            tomips.append("\tli $v0, 4\n");
            tomips.append("\tsyscall\n");
            tomips.append("\tb Finsi" + conditionIndex + "\n");
            tomips.append("\tSinon" + conditionIndex + " : \n");
            tomips.append("\tla $a0, strfaux\n");
            tomips.append("\tli $v0, 4\n");
            tomips.append("\tsyscall\n");
            tomips.append("\tFinsi" + conditionIndex + " : \n");
        }
        return tomips.toString();
    }
}
