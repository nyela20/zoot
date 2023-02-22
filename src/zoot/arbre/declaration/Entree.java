package zoot.arbre.declaration;

public abstract class Entree {
    protected final String idf;

    protected Entree(String idf) { this.idf = idf; }
    public String getIdentifiant(){ return this.idf;}

}
