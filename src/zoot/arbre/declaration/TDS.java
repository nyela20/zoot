package zoot.arbre.declaration;

import java.util.ArrayList;

public class TDS {
    private static TDS instance;
    private final ArrayList<TDSBloc> blocs = new ArrayList<>();
    private int baseID;

    private int etiquetteIndex = 0;

    private TDSBloc blocCourant = new TDSBloc(null);


    public TDS(){
        blocs.add(blocCourant);
    }

    public static TDS getInstance(){
        if(instance == null) instance = new TDS();
        return instance;
    }

    //A FINIR
    public void entrerBloc(){
        ++baseID;//Incrémentation de la base courante
        blocCourant = blocs.get(baseID); // Recuperer la base
        boolean b = baseID == blocs.size() - 1;
        if(b) baseID = 0; //Base principale
    }

    public void sortirBloc(){ blocCourant = blocCourant.getBlocparent(); }


    //a tester en cas de null retour
    public int getBase(Entree entree){
        TDSBloc blocRef = blocCourant; //le bloc courant
        //tant que on a pas retrouver aller chercher dans le bloc parent
        while (blocRef.identifier(entree) == null){ blocRef = blocCourant.getBlocparent(); }
        return blocRef.getNumBloc();
    }

    public String generationNouvelleEtiquette(){
        return gererationEtiquetteIncrementation();
    }

    //a modifier pour plus tard
    private String gererationEtiquetteIncrementation() {
        this.etiquetteIndex++;
        return "label" + etiquetteIndex;
    }

    public SymboleFonction getSymboleBloc(){
        return blocCourant.getSymbolefonction(); //retourner le Type du bloc courant
    }

    public int getBase(){
        //retourner la base du bloc courant à modifier pour zoot3
        return blocCourant.getNumBloc();
    }

    public int getTailleVariables(){
        return blocCourant.getTailleVariables();
    }

    public int getTailleParametres(){
        return blocCourant.getTailleParametres();
    }

    private void createBloc(SymboleFonction symbolefonction){
        TDSBloc newTDS = new TDSBloc(blocCourant, symbolefonction);
        blocs.add(newTDS); blocCourant = newTDS;
    }

    public boolean ajouterEntreeEtSymbole(Entree entree, SymboleFonction symbole) {
        boolean ok = blocCourant.ajouter(entree, symbole);
        createBloc(symbole);
        //System.out.println(blocs);
        return ok;
    }

    public boolean ajouterEntreeEtSymbole(Entree entree, SymboleVariable symbole, boolean isparam) {
        //System.out.println(blocCourant);
        return blocCourant.ajouterSymbole(entree, symbole,isparam);
    }

    //A TESTER EN CAS DE RETOUR NULL
    public Symbole identifier(Entree entree) {
        TDSBloc tdsBloc = blocCourant;
        while (tdsBloc != null){
            if(tdsBloc.identifier(entree) != null)
                return tdsBloc.identifier(entree);
            tdsBloc = tdsBloc.getBlocparent();
        }
        return null;
    }
    public void test(){
        //System.out.println("->" + e);
    }

}
