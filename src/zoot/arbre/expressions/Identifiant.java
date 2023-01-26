package zoot.arbre.expressions;

public class Identifiant extends Constante{

    public Identifiant(String texte, int n){
        super(texte, n);
    }

    @Override
    public String toMIPS() {
        return null;
    }
}
