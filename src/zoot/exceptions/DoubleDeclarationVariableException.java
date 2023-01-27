package zoot.exceptions;

public class DoubleDeclarationVariableException extends AnalyseException {
    public DoubleDeclarationVariableException(int ligne, int colonne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + " colonne " + colonne + "\n\t" + m + " : double déclaration de la variable");
    }
}
