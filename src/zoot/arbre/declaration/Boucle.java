package zoot.arbre.declaration;

import zoot.arbre.Bloc;
import zoot.arbre.instructions.Instruction;
import zoot.exceptions.AnalyseSemantiqueException;

public class Boucle extends Instruction {

    private Expression conditionArret;
    private Bloc executer;
    private int incrementer;
    private Bloc BlocSI;
    private Bloc blocSinon;
    private String etiquette;

    public Boucle(Expression conditionArret, Bloc executer, int n) {
        super(n);
        this.incrementer = 0;
        this.etiquette = "BoucleTantQue_";
        this.conditionArret = conditionArret;
        this.executer = executer;
    }

    @Override
    public void verifier() {
        //Verifier que la condtion d'arret soit semantiquement correcte.
        conditionArret.verifier();
        //Verifier que le bloc à executer soit correct
        executer.verifier();
        if(conditionArret.getSymbole() != Expression.Type.UNDEFINED && conditionArret.getSymbole() != Expression.Type.BOOLEEN) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Le type de la condition tant que n'est pas de type booleen !");
    }


    public Bloc getBlocSI() {
        return BlocSI;
    }

    public Bloc getBlocSinon() {
        return blocSinon;
    }

    public Expression getConditionArret() {
        return conditionArret;
    }

    public int getIncrementer() {
        return incrementer;
    }

    public Bloc getExecuter() {
        return executer;
    }

    public void setBlocSinon(Bloc blocSinon) {
        this.blocSinon = blocSinon;
    }

    public void setConditionArret(Expression conditionArret) {
        this.conditionArret = conditionArret;
    }

    public void setExecuter(Bloc executer) {
        this.executer = executer;
    }

    public void setBlocSI(Bloc blocSI) {
        BlocSI = blocSI;
    }

    public String getEtiquette() {
        return etiquette;
    }

    @Override
    public String toMIPS() {
        /*
        this.etiquette = TDS.getInstance().generationNouvelleEtiquette();
        StringBuilder tomips = new StringBuilder();
        tomips.append("\t #Repeter tant que \n");
        tomips.append("\t" + this.etiquette +":\n");
        tomips.append("\t #Bloc de la boucle repeter \n");
        tomips.append(executer.toMIPS());
        tomips.append("\t #La condition d arret de la boucle \n");
        tomips.append(conditionArret.toMIPS());
        tomips.append("beq $v0, $zero," + this.etiquette + "\n");
        return tomips.toString();
         */
        return "";
    }
}
