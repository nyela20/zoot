package zoot.arbre.declaration;

public class Produit extends Binaire{
    /**
     * @param n le numéro de la ligne
     */
    public Produit(Expression opGauche, Expression opDroite, int n) {
        super(opGauche, opDroite, n);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }

    @Override
    public Type getSymbole() {
        return null;
    }
}
