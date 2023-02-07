package zoot.exceptions;

public class VariableIndefinieException extends AnalyseException {
    public VariableIndefinieException(int ligne, String m) {
        super("ERREUR SEMANTIQUE : " + ligne + " : variable " + m + " non définie");
    }
}
