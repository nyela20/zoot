package zoot.arbre.declaration;

import java.util.Objects;

public class EntreeFonction extends Entree {

    protected static final String ligne = "" + "\n\t#Saut de ligne\n" + "\tla $a0, saut\n" + "\tli $v0, 4\n" + "\tsyscall";

    private final int nbParams;

    /**
     *
     * @param identifiant Identifiant de la fonction
     * @param nbParams le nombre de paramètre
     */
    public EntreeFonction(String identifiant, int nbParams) {
        super(identifiant);
        this.nbParams = nbParams;
    }

    @Override
    public Symbole getSymbole() {
        return Symbole.FONCTION;
    }

    public int getNbParams(){
        return nbParams;
    }

    @Override
    public String toString() {
        return identifiant;
    }

    @Override
    public boolean equals(Object instanceOfObject) {
        if (this == instanceOfObject) return true;
        if (instanceOfObject == null || getClass() != instanceOfObject.getClass()) return false;
        if(nbParams != ((EntreeFonction) instanceOfObject).getNbParams()) return false;
        return super.equals(instanceOfObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }


}
