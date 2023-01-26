package zoot.arbre.expressions;

public class ConstanteBooleene extends Constante{

    public ConstanteBooleene(String texte, int n){
        super(texte, n);
    }

    @Override
    public String toMIPS() {
        return cste;
    }
}
