package zoot.arbre.instructions;

import zoot.arbre.BlocPrincipale;
import zoot.arbre.declaration.Expression;

public class Ecrire extends Instruction {

    private final static String sautLigne = "\t#Passage à la ligne\n" +
            "\tla $a0, saut\n" +
            "\tli $v0, 4\n" +
            "\tsyscall\n";

    protected Expression exp ;

    public Ecrire (Expression e, int n) {
        super(n) ;
        exp = e ;
    }

    @Override
    public void verifier() {
        exp.verifier();
    }

    @Override
    public String toMIPS() {
        String ecrire;
        StringBuilder finalTomips = new StringBuilder();
        if(exp.getSymbole() == Expression.Type.ENTIER){
            StringBuilder tomips = new StringBuilder();
            tomips.append("\tla $a0, ($v0)\n" + "\tli $v0, 1\n");
            ecrire = exp.toMIPS() + tomips;
        }
        else{
            StringBuilder tomips = new StringBuilder();
            tomips.append( "\tjal " + BlocPrincipale.getEtiquette() + "\n" +  "\tla $a0, ($v0)\n" + "\tli $v0, 4\n");
            ecrire = exp.toMIPS() + tomips;
        }
        finalTomips.append("\tsyscall\n" +  "\t#Passage à la ligne\n" + "\tla $a0, saut\n" + "\tli $v0, 4\n" + "\tsyscall\n");
        return "\t#ecrire "+this.exp+"\n" + ecrire + finalTomips;
    }
}
