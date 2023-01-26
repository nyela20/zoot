package zoot.arbre.declaration;

public class Symbole{

    protected String nom;
    private int deplacement;

    public Symbole(int deplacement,String nom){
        this.nom = nom;
        this.deplacement = deplacement;
    }

    public Symbole(String nom){
        this.nom = nom;
    }

    public String getSymbole(){
        return nom;
    }

    public void setDeplacement(final int deplacement) {
        this.deplacement = deplacement;
    }

    public int getDeplacement() {
        return deplacement;
    }
}