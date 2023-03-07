package zoot.arbre.declaration;

public class SymboleVariable extends Symbole {
    private int numeroDeplacementVariable;

    public SymboleVariable(Expression.Type symbole) {
        super(symbole);
    }

    public void setNumeroDeplacementVariable(int numeroDeplacementVariable) {
        this.numeroDeplacementVariable = numeroDeplacementVariable;
    }

    public int getNumeroDeplacementVariable() {
        return numeroDeplacementVariable;
    }

    public void setNumBloc(int numBloc) {
    }
}
