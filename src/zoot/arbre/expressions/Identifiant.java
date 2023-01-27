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
    public String toMIPS() {
        StringBuilder tomips = new StringBuilder();
        Symbole symbole = TDS.getInstance().identifier(this.cste);
        //Si l'identifiant est un entier.
        if(symbole.getSymbole().compareTo("entier") == 0) {
            tomips.append("\t#ecrire " + this.cste + "\n");
            tomips.append("\tlw $a0, " + symbole.getDeplacement() + "($s7)\n");
            tomips.append("\tli $v0, 1");
        }
        return tomips.toString();
    }
}
