package zoot.exceptions;

public class VariableIndefinieException extends AnalyseException {
    public VariableIndefinieException(int ligne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t " + m + " : variable indéfinie");
    }
}
