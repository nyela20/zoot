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
        if(exp.getSymbole() == Expression.Type.ENTIER){
            StringBuilder tompis1 = new StringBuilder();
            tompis1.append("\tla $a0, ($v0)\n");
            tompis1.append("\tli $v0, 1\n");
            ecrire = exp.toMIPS() + tompis1;
        }
        else{
            StringBuilder tomips2 = new StringBuilder();
            tomips2.append("\tjal " + BlocPrincipale.getBooleanToStringLabel() + "\n");
            tomips2.append("\tla $a0, ($v0)\n");
            tomips2.append("\tli $v0, 4\n");
            ecrire = exp.toMIPS() + tomips2;
        }

        return "#ecrire " + this.exp.toString() + "\n" +
                ecrire +
                "\tsyscall\n" +
                sautLigne;
    }
}
