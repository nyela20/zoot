package zoot.arbre;

import zoot.arbre.instructions.Instruction;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 * @author Ny Elanirina RALANTONISAINANA
 * @author Théo FAEDO
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<Instruction> programme ;

    /**
     * @brief Constructeur de la classe BlocDInstructions
     * @param n numéro de la ligne du bloc d'instructions dans le fichier .zoot
     */
    public BlocDInstructions(int n) {
        super(n) ;
        programme = new ArrayList<>() ;
    }

    /**
     * @brief Fonction qui empile les instructions du programme
     * @param i une instruciton
     */
    public void ajouter(Instruction i) {
        programme.add(i) ;
    }

    /**
     * @brief Fonction qui analyse la sémantique de l'arbre abstrait construit.
     * @throws UnsupportedOperationException exception
     */
    @Override
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verifier non définie ") ;
    }

    /**
     * @brief Fonction qui génére de code de l’arbre abstrait vérifié
     * @return le code de l'arbre abstrait vérifié
     */
    @Override
    public String toMIPS() {
        verifier();
        //En-tête du code mips
        StringBuilder mips = new StringBuilder();
        mips.append("#RALANTONISAINANA Ny Elanirina & FAEDO Théo \n" +
                ".data \n" +
                "\tsaut: .asciiz \"\\n\"\n" +
                "\tvrai: .word 1\n" +
                "\tfaux: .word 0\n" +
                "\tstrvrai: .asciiz \"vrai\"\n" +
                "\tstrfaux: .asciiz \"faux\"\n" +
                ".text\n" +
                "main:\n");
        //Corps du code mips
        for(Instruction instruction : programme) {
            mips.append(instruction.toMIPS() + "\n");
        }
        //Fin du programme
        mips.append("\t#Fin du programme\n" +
                "\tli $v0, 10\n" +
                "\tsyscall");
        return mips.toString();
    }

    @Override
    public String toString() {
        return programme.toString() ;
    }
}
