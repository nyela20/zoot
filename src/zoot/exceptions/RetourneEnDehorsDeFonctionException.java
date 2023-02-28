package zoot.exceptions;

public class RetourneEnDehorsDeFonctionException extends AnalyseException{

    protected RetourneEnDehorsDeFonctionException(int ligne) {
        super("ERREUR SEMANTIQUE : " + ligne + " : instruction retourne en dehors d'un corp de fonction");
    }
}
