package zoot.arbre;

import zoot.arbre.instructions.Retourne;

import java.util.ArrayList;
import java.util.Iterator;

public class Bloc extends ArbreAbstrait implements Iterable<ArbreAbstrait> {

    private final ArrayList<ArbreAbstrait> arbreAbstraits;
    private boolean instructionRetour = false;



    public Bloc(int n) {
        super(n);
        this.arbreAbstraits = new ArrayList<>();
    }

    public boolean instructiondeRetour() {
        return !instructionRetour;
    }

    public void ajouter(ArbreAbstrait element) {
        if (element instanceof Retourne) instructionRetour = true;
        arbreAbstraits.add(element);
    }


    @Override
    public int getNoLigne() {
        return super.getNoLigne();
    }

    @Override
    public Iterator<ArbreAbstrait> iterator() {
        return arbreAbstraits.iterator();
    }

    @Override
    public void verifier() {
        for (ArbreAbstrait elem : arbreAbstraits) {
            elem.verifier();
        }
    }

    @Override
    public String toMIPS() {
        StringBuilder c = new StringBuilder();
        for (ArbreAbstrait elem : arbreAbstraits) {
            c.append(elem.toMIPS()).append("\n");
        }
        return c.toString();
    }


}
