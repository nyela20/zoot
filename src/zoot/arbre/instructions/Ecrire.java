package zoot.arbre.instructions;

import zoot.arbre.expressions.Expression;

public class Ecrire extends Instruction {

    protected Expression exp ;

    public Ecrire (Expression e, int n) {
        super(n) ;
        exp = e ;
    }

    @Override
    public void verifier() {
        throw new UnsupportedOperationException("fonction verfier non définie ") ;
    }

    @Override
    public String toMIPS() {
        String ligne = "" +
                "\t#Saut de ligne\n" +
                "\tla $a0, saut\n" +
                "\tli $v0, 4\n" +
                "\tsyscall";
        // Ecrire une constante entière
        if(exp.estUnEntier()){
            return (exp.toMIPS() + "\n" + ligne);
        }
        throw new UnsupportedOperationException("Type expression non reconnu") ;
    }

}
