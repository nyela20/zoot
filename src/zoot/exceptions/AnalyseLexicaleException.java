package zoot.exceptions;

public class AnalyseLexicaleException extends AnalyseException {
 
    public AnalyseLexicaleException(int ligne, int colonne, String m) {
        super("ERREUR LEXICALE : " + ligne + " : caractère non reconnu") ;
    }

}
