package zoot.arbre.declaration;

import zoot.exceptions.AnalyseException;
import zoot.exceptions.DoubleDeclarationVariableException;
import zoot.exceptions.VariableIndefinieException;

import java.util.HashMap;
import java.util.Iterator;

public class TDS implements Iterable<String> {
    private static final TDS instance = new TDS();
    private HashMap<String,Symbole> tds;

    private int conditionIndex;

    private TDS(){
        this.tds = new HashMap<>();
        this.conditionIndex = 0;
    }

    public static TDS getInstance(){
        return instance;
    }

    private void verifier(final String idf,final Symbole symbole,final int numLigne,final int numColonne) throws DoubleDeclarationVariableException {
        if (this.tds.containsKey(idf)) {
            //Double variables
            throw new DoubleDeclarationVariableException(numLigne,numColonne,idf);
        }
    }

    public void ajouter(final EntreeVariable idf, final Symbole symbole, int numLigne, int numColonne) {
        verifier(idf.getIdentifiant(),symbole,numLigne,numColonne);
        symbole.setDeplacement(this.getPileAllocation());
        this.tds.put(idf.getIdentifiant(), symbole);
        System.out.println(idf.getIdentifiant() + " : " + symbole.getSymbole());
    }

    public void ajouter(final EntreeFonction idf,final SymboleFonction symbole, int numLigne, int numColonne){

    }

    public void entreeBloc(){

    }

    public void sortieBloc(){

    }

    public int getPileAllocation() {
        return this.tds.size() * -4;
    }

    public Symbole identifier(final String e) {
        for (String ee : this) {
            if (ee.compareTo(e) == 0) {
                return (tds.get(ee));
            }
        }
        return null;
    }

    public boolean contains(String idf){
        return this.tds.containsKey(idf);
    }

    public int getConditionIndex(){
        this.conditionIndex ++;
        return conditionIndex;
    }

    @Override
    public Iterator<String> iterator() {
        return this.tds.keySet().iterator();
    }

}
