package zoot.exceptions;

public class MauvaisAffectionTypeException extends AnalyseException{

    public MauvaisAffectionTypeException(int ligne, String m) {
        super("ERREUR SEMANTIQUE : " + ligne + " : le type de valeur entrée ne correspond pas au type de la variable " + m);
    }
}
