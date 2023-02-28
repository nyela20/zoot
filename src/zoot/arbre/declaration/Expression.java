package zoot.arbre.declaration;

import zoot.arbre.ArbreAbstrait;

public abstract class Expression extends ArbreAbstrait {

    protected Expression(int n) {
        super(n);
    }

    public abstract Type getSymbole();

    public enum Type {
        ENTIER,
        BOOLEEN,
        UNDEFINED
    }

    public abstract boolean estUneConstanteBooleenne();

    public abstract boolean estUneConstanteEntiere();

    public abstract boolean estUneAppelDeFonction();

    public abstract boolean estUnIdendifiant();
}

