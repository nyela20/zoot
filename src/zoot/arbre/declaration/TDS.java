package zoot.arbre.declaration;

import zoot.exceptions.AnalyseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TDS implements Iterable<Entree> {
    private static final TDS instance = new TDS();
    private int plc_$sp;
    private int num_SiSinon; //numéro des SI et SINON dans le code MIPS
    private HashMap<Entree,Symbole> tds; //table de symbole
    private int numBloc;
    private int noligne=0;

    private TDS(){
        this.tds = new HashMap<>();
        this.plc_$sp = 0;
        this.num_SiSinon = 10;
        this.numBloc = 0;
    }

    public static TDS getInstance(){
        return instance;
    }

    /**
     * @param p
     * @return
     */
    public int getDeplacementNumero(int p){
        this.plc_$sp += p;
        return this.plc_$sp - p;
    }

    public int setnoLigne(int noli){
        return this.noligne=noli;
    }
    public int getNumBloc(){
        return this.numBloc;
    }


    public int getNumeroSiSinon(){
        this.num_SiSinon ++;
        return this.num_SiSinon -1;
    }


    private void verifier(Entree e,Symbole s){

    }

    public void entreeBloc(){
        this.numBloc += 1;
    }

    public void sortieBloc(){

    }

    /**
     *
     * @param e entrée: nom de la variable
     * @param s symbole type de variable
     * @throws AnalyseException
     */
    public void ajouter(Entree e, Symbole s) throws AnalyseException {
        s.setNumBloc(this.numBloc);
        verifier(e,s);
        tds.put(e, s);
    }

    //Sert à identifier les paramètres de fonctions
    public Entree identifierParametre(int i, int numBloc){
        ArrayList<Entree> entrees = new ArrayList<>();
        for(Entree e : this){
            Symbole s = identifier(e);
            //si on a trouvé un paramètre de la fonction
            if((s.getNumBloc() == numBloc)){
                entrees.add(e);
            }
        }
        return entrees.get(i);
    }



    public Symbole identifier(Entree e) {
        ArrayList<Symbole> s = new ArrayList<>();
        for (Entree ee : this) {
            if (ee.getIdentifiant().compareTo(e.getIdentifiant()) == 0) {
                s.add(tds.get(ee));
            }
        }
        for (Symbole sy : tds.values()) {
            for(Symbole syd : s){
                if (sy.getNumBloc() == syd.getNumBloc()){
                    return syd;
                }
            }
        }
        return null;
    }

    public boolean estVide(){
        return tds.isEmpty();
    }

    public int size32bits() {
        int size = 0;
        for (Entree e : this) {
            Symbole s = identifier(e);
            size = size + 4;
        }
        return size;
    }


    @Override
    public Iterator<Entree> iterator() {
        return this.tds.keySet().iterator();
    }


}
