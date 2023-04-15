package zoot.arbre.declaration;

public class EgaliteBinaire extends Binaire{

    public EgaliteBinaire(Expression opGauche, Expression opDroite, int n) {
        super(opGauche, opDroite, n);
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
