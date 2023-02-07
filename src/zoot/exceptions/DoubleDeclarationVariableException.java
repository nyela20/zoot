package zoot.exceptions;

public class DoubleDeclarationVariableException extends AnalyseException {
    public DoubleDeclarationVariableException(int ligne, int colonne, String m) {
        super("ERREUR SEMANTIQUE : " + ligne + " : double déclaration de la variable " + m);
    }
}
