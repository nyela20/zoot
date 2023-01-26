package zoot.arbre.declaration;

import zoot.exceptions.AnalyseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TDS implements Iterable<String> {
    private static final TDS instance = new TDS();
    private HashMap<String,Symbole> tds;

    private TDS(){
        this.tds = new HashMap<>();
    }

    public static TDS getInstance(){
        return instance;
    }


    private void verifier(String e,Symbole s){

    }


    public void ajouter(final String idf, final Symbole symbole) {
        if (this.tds.containsKey(idf)) {
        }
        symbole.setDeplacement(this.getTailleZoneVariable());
        this.tds.put(idf, symbole);
    }

    public int getTailleZoneVariable() {
        return this.tds.size() * -4;
    }


    public Symbole identifier(String e) {
        for (String ee : this) {
            if (ee.compareTo(e) == 0) {
                return (tds.get(ee));
            }
        }
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return this.tds.keySet().iterator();
    }


}
