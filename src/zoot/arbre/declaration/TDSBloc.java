package zoot.arbre.declaration;

import java.util.HashMap;

public class TDSBloc {
    private static int taille = 1;
    private TDSBloc blocparent;
    private final HashMap<Entree, Symbole> tdsHashMap;
    private SymboleFonction symbolefonction;
    private int numBloc;

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

    public SymboleFonction getSymbolefonction() {return symbolefonction;}
    public int getNumBloc(){
        return numBloc;
    }
    public TDSBloc getBlocparent(){
        return blocparent;
    }

    public boolean ajouterSymbole(Entree entree, SymboleVariable symbole) {
        if (tdsHashMap.containsKey(entree)) return false;
        tdsHashMap.put(entree, symbole);
        return true;
    }

}
