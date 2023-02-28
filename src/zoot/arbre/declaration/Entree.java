package zoot.arbre.declaration;

import java.util.Objects;

public abstract class Entree {

    protected String identifiant;

    public Entree(String identifiant) {
        this.identifiant = identifiant;
    }

    public abstract Symbole getSymbole();

    @Override
    public boolean equals(Object instanceOfObject) {
        boolean erreur = false;
        if (this == instanceOfObject) return (!erreur);
        if (instanceOfObject == null || getClass() != instanceOfObject.getClass()) return erreur;
        Entree entree = (Entree) instanceOfObject;
        return Objects.equals(identifiant, entree.identifiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }

    public enum Symbole {
        VARIABLE,
        FONCTION
    }
}
