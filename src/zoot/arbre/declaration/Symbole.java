package zoot.arbre.declaration;

public abstract class Symbole{

    private String type;
    private int deplacement;

    public Symbole(int deplacement,String type){
        this.type = type;
        this.deplacement = deplacement;
    }

    public Symbole(String type){
        this.type = type;
    }

    public String getSymbole(){
        return type;
    }

    public void setDeplacement(final int deplacement) {
        this.deplacement = deplacement;
    }

    public int getDeplacement() {
        return deplacement;
    }
}