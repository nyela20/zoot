package zoot.exceptions;

public class FonctionSansRetourException extends AnalyseException{

    protected FonctionSansRetourException(int ligne, String m) {
        super("ERREUR SEMANTIQUE : " + ligne + " : fonction " + m + " n'a pas de retour");
    }
}
