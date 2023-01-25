package zoot.arbre.declaration;

public class SymboleVariable extends Symbole{


    public SymboleVariable(String nom, int taille) {
        super(nom);
    }

    @Override
    public String getSymbole() {
        return this.nom;
    }


    public boolean isEntier(){
        return (this.nom.compareTo("entier") == 0);
    }

    public boolean isBooleen(){
        return (this.nom.compareTo("booleen") == 0);
    }


}
