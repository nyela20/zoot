package zoot.arbre.declaration;

import zoot.arbre.ArbreAbstrait;

import java.util.List;

public abstract class Expression extends ArbreAbstrait {

    /**
     *
     * @param n le numéro de la ligne
     */
    protected Expression(int n) {
        super(n);
    }
    public enum Type {ENTIER,BOOLEEN, UNDEFINED}
    public abstract Type getSymbole();
    public int getNombrePlaces(){
        return 1;
    }
}

