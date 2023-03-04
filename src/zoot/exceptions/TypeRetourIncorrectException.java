package zoot.exceptions;

public class TypeRetourIncorrectException extends AnalyseException{

    protected TypeRetourIncorrectException(int ligne, String typeDonne, String typeVoulu) {
        super("ERREUR SEMANTIQUE : " + ligne + " : type de retour " + typeDonne + " incorrect par rapport au type de retour demandé " + typeVoulu);
    }
}
