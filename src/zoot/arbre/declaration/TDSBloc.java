package zoot.arbre.declaration;

import java.util.HashMap;
import java.util.Iterator;

public class TDSBloc implements Iterable<Entree>{
    private static int taille = 1;
    private final TDSBloc blocparent;
    private final HashMap<Entree, Symbole> tdsHashMap;
    private SymboleFonction symbolefonction;
    private final int numBloc;
    private int tailleVariables = 0;

    private int tailleParametres = 8;

    public TDSBloc(TDSBloc blocparent){
        this.tdsHashMap = new HashMap<>();
        this.blocparent = blocparent;
        this.numBloc = taille++;
    }
    public TDSBloc(TDSBloc blocparent, SymboleFonction symbolefonction){
        tdsHashMap = new HashMap<>();
        this.blocparent = blocparent;
        this.symbolefonction = symbolefonction;
        numBloc = taille++;
    }
    public Symbole identifier(Entree entree) {
        if(!tdsHashMap.containsKey(entree)){ return null;}
        return tdsHashMap.get(entree);
    }
    public boolean ajouter(Entree entree, SymboleFonction symbolefonction) {
        boolean erreur = false;
        if(tdsHashMap.containsKey(entree)) return erreur;
        tdsHashMap.put(entree, symbolefonction);
        symbolefonction.setEtiquetteFonction("" + TDS.getInstance().generationNouvelleEtiquette());
        return (!erreur);
    }
    public SymboleFonction getSymbolefonction() {
        return symbolefonction;
    }
    public int getNumBloc(){
        return numBloc;
    }
    public TDSBloc getBlocparent(){
        return blocparent;
    }
    public boolean ajouterSymbole(Entree entree, SymboleVariable symbole, boolean isparam) {
        boolean erreur = false;
        if (tdsHashMap.containsKey(entree)){
            return erreur;
        }
        tdsHashMap.put(entree, symbole);
        if(!isparam) { this.tailleVariables -= 4;
            symbole.setNumeroDeplacementVariable(tailleVariables);
        }
        else{ this.tailleParametres += 4;
            symbole.setNumeroDeplacementVariable(tailleParametres);
        }
        return !erreur;
    }
    public int getTailleVariables() {
        return tailleVariables;
    }

    public int getTailleParametres(){
        return tailleParametres;
    }
    @Override
    public Iterator<Entree> iterator() {
        return this.tdsHashMap.keySet().iterator();
    }
}
