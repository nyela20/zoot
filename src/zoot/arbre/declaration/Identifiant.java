package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class Identifiant extends Expression {

    private String identifiant;

    /**
     *
     * @param identifiant le nom de l'identifiant
     * @param n le numero de la ligne
     */
    public Identifiant(String identifiant, int n) {
        super(n);
        this.identifiant = identifiant;
    }
    @Override
    public void verifier() {
        if(TDS.getInstance().identifier(new EntreeVariable(identifiant)) == null){
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Variable " + identifiant + " non déclarée");
        }
    }

    @Override
    public String toMIPS() {
        StringBuilder tompis = new StringBuilder();
        tompis.append("\tlw $v0, ($a0)\n");
        return this.getBaseEtDeplacement() + tompis;
    }

    @Override
    public Type getSymbole() {
        Type sym = TDS.getInstance().identifier(new EntreeVariable(identifiant)).getType();
        if(sym == null) return Type.UNDEFINED;
        return sym;
    }

    @Override
    public String toString() {
        return identifiant;
    }

    public String getBaseEtDeplacement(){
        String redirection = TDS.getInstance().generationNouvelleEtiquette();
        int deplacementId = ((SymboleVariable)TDS.getInstance().identifier(new EntreeVariable(identifiant))).getNumeroDeplacementVariable();
        String redirectionEnd = TDS.getInstance().generationNouvelleEtiquette();

        StringBuilder tompis = new StringBuilder();
        tompis.append("\t#identifiant " + this.identifiant +"\n");
        tompis.append("\tlw $v0, ($s7)\n");
        tompis.append("\tla $a0, ($s7)\n\n");

        tompis.append(redirection + " :\n");
        tompis.append("\tbeq $v0, " + TDS.getInstance().getBase(new EntreeVariable(identifiant)) + ", " + redirectionEnd + "\n");
        tompis.append("\tlw $a0, 4($a0)\n");
        tompis.append("\tlw $v0, ($a0)\n");
        tompis.append("\tj " + redirection + "\n\n");
        tompis.append(redirectionEnd + " :\n");

        return  tompis + "\tla $a0, " + deplacementId + "($a0)\n";
    }
}
