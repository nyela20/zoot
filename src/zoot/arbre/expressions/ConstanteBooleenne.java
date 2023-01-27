package zoot.arbre.expressions;

public class ConstanteBooleenne extends Constante{

    public ConstanteBooleenne(String texte, int n){
        super(texte, n);
    }

    @Override
    public boolean estConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estConstanteBooleenne() {
        return true;
    }

    @Override
    public String toMIPS() {
        return cste;
    }


}
