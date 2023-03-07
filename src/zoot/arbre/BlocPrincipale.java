package zoot.arbre;

import zoot.arbre.declaration.TDS;

public class BlocPrincipale extends ArbreAbstrait {

    private Bloc blocFonctions;
    private Bloc blocInstructions;

    public BlocPrincipale(int n) {
        super(n);
    }
    public void setBlocFonctions(Bloc bloc){
        this.blocFonctions = bloc;
    }
    public void setBlocInstructions(Bloc bloc){
        this.blocInstructions = bloc;
    }

    @Override
    public void verifier() {
        blocFonctions.verifier();
        blocInstructions.verifier();
    }

    @Override
    public String toMIPS() {
        TDS.getInstance().test();
        booleanToStringLabel = TDS.getInstance().generationNouvelleEtiquette();
        String booleanToStringElseLabel = TDS.getInstance().generationNouvelleEtiquette();
        String mainLabel = TDS.getInstance().generationNouvelleEtiquette();
        String endLabel = TDS.getInstance().generationNouvelleEtiquette();

        return  "#RALANTONISAINANA Ny Elanirina & FAEDO Théo \n" +
                ".data\n" +
                "\tsaut: .asciiz \"\\n\"\n" +
                "\tvrai: .asciiz \"vrai\"\n" +
                "\tfaux: .asciiz \"faux\"\n" +
                ".text\n" +
                "\tj " + mainLabel + "\n" +

                booleanToStringLabel + ":\n" +
                "\tbeq $v0, $0, " + booleanToStringElseLabel + "\n" +
                "\tla $v0, vrai\n" +
                "\tjr $ra\n" +
                booleanToStringElseLabel + ":\n" +
                "\tla $v0, faux\n" +
                "\tjr $ra\n\n" +

                blocFonctions.toMIPS() +

                "#Programme principale\n" +
                mainLabel + " :\n" +

                "\t#Initialisation du programme principale\n" +
                "\tli $v0, 1 #Numéro de la base\n" +
                "\tsw $v0, ($sp) #Empiler le numéro de la base\n" +
                "\tmove $s7, $sp\n" +
                "\taddi $sp, $sp, " + (TDS.getInstance().getTailleVariables()-4)  + "\n" +

                "\t"+blocInstructions.toMIPS() +
                endLabel + " :\n" +
                "\t#Fin du programme\n" +
                "\tli $v0, 10\n" +
                "\tsyscall\n\n" ;
    }

    private static String booleanToStringLabel;
    public static String getEtiquette(){
        return booleanToStringLabel;
    }
}
