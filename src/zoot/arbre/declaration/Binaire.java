package zoot.arbre.declaration;

public abstract class Binaire extends Expression{
    protected Expression operandeGauche, operandeDroite;

    /**
     * @param n le numéro de la ligne
     */
    protected Binaire(int n) {
        super(n);
    }

    public Binaire(Expression opGauche, Expression opDroite, int n) {
        super(n);
        this.operandeGauche = opGauche;
        this.operandeDroite = opDroite;
    }

    @Override
    public void verifier() {
        this.operandeGauche.verifier();
        this.operandeDroite.verifier();
    }

    @Override
    public int getNombrePlaces(){
        if(operandeDroite.getNombrePlaces() == operandeGauche.getNombrePlaces()){
            return operandeDroite.getNombrePlaces()+1;
        }
        return Math.max(operandeDroite.getNombrePlaces(), operandeGauche.getNombrePlaces());
    }
}
