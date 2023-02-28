package zoot.arbre.declaration;

import java.util.Objects;

public class EntreeFonction extends Entree {

    protected static final String ligne = "" + "\n\t#Saut de ligne\n" + "\tla $a0, saut\n" + "\tli $v0, 4\n" + "\tsyscall";

    public EntreeFonction(String identifiant) {
        super(identifiant);
    }

    @Override
    public Symbole getSymbole() {
        return Symbole.FONCTION;
    }

    @Override
    public String toString() {
        return identifiant;
    }

    @Override
    public boolean equals(Object instanceOfObject) {
        if (this == instanceOfObject) return true;
        if (instanceOfObject == null || getClass() != instanceOfObject.getClass()) return false;
        if (!super.equals(instanceOfObject)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }


}
