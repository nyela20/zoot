package zoot.arbre.declaration;

import zoot.arbre.ArbreAbstrait;
import zoot.arbre.Bloc;
import zoot.exceptions.AnalyseSemantiqueException;

public class Fonction extends ArbreAbstrait {

    private String identifiant;
    private Bloc blocFct;

    public Fonction(String identifiant, Bloc blocFct, int n) {
        super(n);
        this.identifiant = identifiant;
        this.blocFct = blocFct;
    }

    @Override
    public void verifier() {
        TDS.getInstance().entrerBloc(); //Entrée dans le bloc
        if (TDS.getInstance().identifier(new EntreeVariable(identifiant)) != null) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, " : La fonction " + identifiant + "() a le même identifiant que la variable " + identifiant + " déclarée précedemment");
        }
        blocFct.verifier();
        if (!blocFct.instructiondeRetour()) {
            AnalyseSemantiqueException.raiseAnalyseSemantiqueException(noLigne, " : La fonction " + identifiant + " n'a pas d'instruction de retour");
        }
        TDS.getInstance().sortirBloc(); //Sortie de bloc
    }

    @Override
    public String toMIPS() {
        String etiquetteFonction = ((SymboleFonction) TDS.getInstance().identifier(new EntreeFonction(identifiant))).getEtiquetteFonction();
        TDS.getInstance().entrerBloc(); //Entrée bloc
        StringBuilder tomips = new StringBuilder();
        tomips.append("#Programme de la fonction " + this.identifiant + "() \n");
        tomips.append(etiquetteFonction + " :\n");
        tomips.append("\t#Initialisation de la fonction " + this.identifiant + "() \n");
        tomips.append("\t#Empiler l'adresse de retour de la fonction\n");
        tomips.append("\tsw $ra, ($sp) #Empiler $ra\n");
        tomips.append("\t#Chainage dynamique entre fonction appelante et fonction appelée\n");
        tomips.append("\tla $a0, ($s7) #Empiler ($s7)\n");
        tomips.append("\tsw $a0, -4($sp) #Empiler ($s7)\n");
        tomips.append("\tli $v0, " + TDS.getInstance().getBase() + " #Numéro de la base\n");
        tomips.append("\tsw $v0, -8($sp) #Empiler le numéro de la base\n");
        tomips.append("\taddi $sp, $sp, -8 #Repositionner le sommet de la pile\n");
        tomips.append("\tmove $s7, $sp #Mettre a jour l'adresse de ($s7)\n");
        tomips.append("\taddi $sp, $sp, -4 \n");
        tomips.append("\t"+blocFct.toMIPS());
        TDS.getInstance().sortirBloc(); //Sortie de bloc
        return tomips.toString();
    }

    public String getIdentifiant() {
        return identifiant;
    }
}
