package zoot.arbre.declaration;

import zoot.exceptions.AnalyseSemantiqueException;

public class Identifiant extends Expression {

    private String identifiant;

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
        tompis.append("\n\tlw $v0, ($a0)\n");
        return this.getAdresse() + tompis;
    }

    @Override
    public Type getSymbole() {
        Type sym = TDS.getInstance().identifier(new EntreeVariable(identifiant)).getType();
        if(sym == null) return Type.UNDEFINED;
        return sym;
    }

    @Override
    public boolean estUneConstanteBooleenne() {
        return false;
    }

    @Override
    public boolean estUneConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estUneAppelDeFonction() {
        return false;
    }

    @Override
    public boolean estUnIdendifiant() {return false;}


    @Override
    public String toString() {
        return identifiant;
    }

    public String getAdresse(){
        String redirection = TDS.getInstance().generationNouvelleEtiquette();
        int deplacementId = ((SymboleVariable)TDS.getInstance().identifier(new EntreeVariable(identifiant))).getNumeroDeplacementVariable();
        String redirectionEnd = TDS.getInstance().generationNouvelleEtiquette();
        StringBuilder tompis = new StringBuilder();
        tompis.append("# get base\n");
        tompis.append("lw $v0, ($s7)\n");
        tompis.append("la $a0, ($s7)\n");
        tompis.append(redirection + " :\n");
        tompis.append("beq $v0, " + TDS.getInstance().getBase(new EntreeVariable(identifiant)) + ", " + redirectionEnd + "\n");
        tompis.append("lw $a0, 4($a0)\n");
        tompis.append("lw $v0, ($a0)\n");
        tompis.append("j " + redirection + "\n");
        tompis.append(redirectionEnd + " :\n");
        return  tompis + "la $a0, " + deplacementId + "($a0)\n";
    }
}
