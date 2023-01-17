package zoot.arbre.expressions;

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

    @Override
    public boolean estUnEntier() {
        return true;
    }

    @Override
    public String toMIPS() {
        return "\t#ecrire " + this.toString() + "\n" +
                "\tli $a0, " + this.toString() + "\n" +
                "\tli $v0 , 1 " + "\n" +
                "\tsyscall";
    }
}
