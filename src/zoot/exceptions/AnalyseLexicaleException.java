package zoot.exceptions;

public class AnalyseLexicaleException extends AnalyseException {
 
    public AnalyseLexicaleException(int ligne, int colonne, String m) {
        super("ERREUR LEXICALE : ligne " + ligne + " colonne " + colonne + " : " + m + " : caractère non reconnu") ;
    }

}
