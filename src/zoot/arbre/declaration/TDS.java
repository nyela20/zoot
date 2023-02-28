package zoot.arbre.declaration;

import java.util.ArrayList;

public class TDS {
    private static TDS instance;
    private final ArrayList<TDSBloc> blocs = new ArrayList<>();
    private int conditionIndex = 0;
    private int baseID;

    private int etiquetteIndex = 0;

    private StringBuilder etiquetteCourant = new StringBuilder("a");

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
        baseID = ++baseID; //Incrémentation de la base courante
        blocCourant = blocs.get(baseID); // Recuperer la base
        boolean b = baseID == blocs.size() - 1;
        if(b) baseID = 0; //Base principale
    }

    public int getConditionIndex(){
        this.conditionIndex ++;
        return conditionIndex;
    }

    public void sortirBloc(){ blocCourant = blocCourant.getBlocparent(); }


    //a tester en cas de null retour
    public int getBase(Entree entree){
        TDSBloc blocRef = blocCourant; //le bloc courant
        //tant que on a pas retrouver aller chercher dans le bloc parent
        while (blocRef.identifier(entree) == null){ blocRef = blocCourant.getBlocparent();}
        return blocRef.getNumBloc();
    }

    public String generationNouvelleEtiquette(){
        return gererationEtiquelleIncrementation();
    }

    //a modifier pour plus tard
    private String gererationEtiquelleIncrementation(){
        this.etiquetteIndex ++;
        etiquetteCourant = new StringBuilder("label" + etiquetteIndex);
        return etiquetteCourant.toString();
    }

    public SymboleFonction getSymboleBloc(){
        return blocCourant.getSymbolefonction(); //retourner le Type du bloc courant
    }

    public int getBase(){
        //retourner la base du bloc courant à modifier pour zoot3
        return blocCourant.getNumBloc();
    }

    private void blocPrincipaleInit(SymboleFonction symbolefonction){
        TDSBloc newTDS = new TDSBloc(blocCourant, symbolefonction);
        blocs.add(newTDS); blocCourant = newTDS;
    }

    public boolean ajouterEntreeEtSymbole(Entree entree, SymboleFonction symbole) {
        boolean ok = blocCourant.ajouter(entree, symbole);
        blocPrincipaleInit(symbole);
        return ok;
    }

    public boolean ajouterSymbole(Entree entree, SymboleVariable symbole) {
        return blocCourant.ajouterSymbole(entree, symbole);
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

}
