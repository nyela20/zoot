package zoot.arbre.declaration;

public class Addition extends Binaire{

    /**
     * @param n le numéro de la ligne
     */
    public Addition(Expression opGauche, Expression opDroite, int n) {
        super(opGauche, opDroite, n);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        StringBuilder stringBuilder = new StringBuilder();
        return "";
    }

    @Override
    public Type getSymbole() {
        return null;
    }
}
