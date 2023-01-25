package zoot.arbre.declaration;

public abstract class Symbole{

    protected final String nom;
    private int numBloc;
    private final int deplacement; //adresse de retour de la fonction

    public Symbole(String nom){
        this.nom = nom;
        this.numBloc = -1;
        this.deplacement = TDS.getInstance().getDeplacementNumero(4);
    }

    public void setNumBloc(int numBloc) {
        this.numBloc = numBloc;
    }

    public int getNumBloc(){
        return this.numBloc;
    }

    public abstract String getSymbole();

    public int getDeplacement() {
        return deplacement;
    }
}