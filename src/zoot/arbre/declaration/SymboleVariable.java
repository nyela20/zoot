package zoot.arbre.declaration;

public class SymboleVariable extends Symbole {
    private int numeroDeplacementVariable;
    private int numBloc;

    public SymboleVariable(Expression.Type symbole) {
        super(symbole);
        this.numBloc = TDS.getInstance().getBase();
    }

    public void setNumeroDeplacementVariable(int numeroDeplacementVariable) {
        this.numeroDeplacementVariable = numeroDeplacementVariable;
    }

    public int getNumeroDeplacementVariable() {
        return numeroDeplacementVariable;
    }

    public int getNumBloc() {
        return numBloc;
    }

    public void setNumBloc(int numBloc) {
        this.numBloc = numBloc;
    }
}
