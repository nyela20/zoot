package zoot.arbre;

import zoot.arbre.fonction.Fonction;

import java.util.ArrayList;
import java.util.Iterator;

public class BlocFonctions extends ArbreAbstrait implements Iterable<Fonction>{

    public ArrayList<Fonction> fonctions;

    public BlocFonctions(int n) {
        super(n);
        this.fonctions = new ArrayList<>();
    }

    public void ajouter(Fonction f){
        fonctions.add(f);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }

    @Override
    public String toString(){
        return fonctions.toString() ;
    }

    @Override
    public Iterator<Fonction> iterator() {
        return this.fonctions.iterator();
    }
}