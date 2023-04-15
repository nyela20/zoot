package zoot.arbre.declaration;

public class NonEgaliteBinaire extends Binaire{
    public NonEgaliteBinaire(Expression opGauche, Expression opDroite, int n) {
        super(opGauche, opDroite, n);
    }

    @Override
    public String toMIPS() {
        return "";
    }

    @Override
    public Type getSymbole() {
        return Expression.Type.BOOLEEN;
    }
}
