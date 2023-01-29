package zoot.arbre.expressions;

import zoot.arbre.declaration.Symbole;
import zoot.arbre.declaration.TDS;

public class ConstanteBooleenne extends Constante{

    public ConstanteBooleenne(String texte, int n){
        super(texte, n);
    }

    @Override
    public boolean estConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estConstanteBooleenne() {
        return true;
    }

    @Override
    public boolean estIdf() {
        return false;
    }

    public String toStrBool(String valeur){
        if(valeur.compareTo("vrai") == 0) return "strvrai";
        return "strfaux";
    }

    @Override
    public String toMIPS() {
        return "\t#ecrire " + this.cste + "\n" +
                "\tla $a0, " + toStrBool(this.cste) + "\n" +
                "\tli $v0, 4 \n" +
                "\tsyscall\n";
    }

}
