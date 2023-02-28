package zoot.exceptions;

public class AnalyseSemantiqueException {
    private static boolean hasFailed = false;

    public static void raiseAnalyseSemantiqueException(int ligne, String message) {
        System.out.println("ERREUR SEMANTIQUE : ligne " + ligne + " : " + message);
        hasFailed = true;
    }

    public static boolean getHasFailed() {
        return hasFailed;
    }
}
