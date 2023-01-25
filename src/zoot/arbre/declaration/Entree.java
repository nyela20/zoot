package zoot.arbre.declaration;

public abstract class Entree {

    protected final String identifiant;

    public Entree(String nomVariable){
        this.identifiant = nomVariable;
    }


    public abstract String getIdentifiant();

}
