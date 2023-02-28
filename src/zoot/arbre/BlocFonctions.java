package zoot.arbre;

import zoot.arbre.declaration.EntreeFonction;
import zoot.arbre.declaration.EntreeVariable;
import zoot.arbre.declaration.SymboleFonction;
import zoot.arbre.declaration.TDS;
import zoot.exceptions.AnalyseSemantiqueException;

public class BlocFonctions extends ArbreAbstrait {

    private String identifiant;
    private Bloc bloc;

    public BlocFonctions(String identifiant, Bloc bloc, int n) {
        super(n);
        this.identifiant = identifiant;
        this.bloc = bloc;
    }

    @Override
    public void verifier() {
        TDS.getInstance().entrerBloc();
        if(TDS.getInstance().identifier(new EntreeVariable(identifiant)) != null) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Erreur : La fonction  " + identifiant + " porte le même nom que la variable " + identifiant+ " déclarée précedemment");bloc.verifier();
        if (!bloc.instructiondeRetour()) AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, "Erreur : La fonction " + identifiant + " ne porte pas d'instruction retourner");
        TDS.getInstance().sortirBloc();
    }

    public String getIdentifiant(){
        return identifiant;
    }

    @Override
    public String toMIPS() {
        String etiquetteFonction = ((SymboleFonction)TDS.getInstance().identifier(new EntreeFonction(identifiant))).getEtiquetteFonction();
        TDS.getInstance().entrerBloc();
        StringBuilder tomips = new StringBuilder();
                tomips.append("# === " + identifiant + " === \n");
                tomips.append(etiquetteFonction + " :\n");
                tomips.append("# Init memoire fonction\n");
                // adresse de retour
                tomips.append("sw $ra, ($sp)\n");
                // chainage dynamique
                tomips.append("la $a0, ($s7)\n");
                tomips.append("sw $a0, -4($sp)\n");
                // numéro de région
                tomips.append("li $v0, " + TDS.getInstance().getBase() + "\n");
                tomips.append("sw $v0, -8($sp)\n");
                tomips.append("addi $sp, $sp, -8\n");
                tomips.append("move $s7, $sp\n");
                tomips.append("addi $sp, $sp, -4\n");
                tomips.append(bloc.toMIPS());
        TDS.getInstance().sortirBloc();
        return tomips.toString();
    }

}
