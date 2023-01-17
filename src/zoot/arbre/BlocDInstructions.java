package zoot.arbre;

import zoot.arbre.instructions.Instruction;

import java.util.ArrayList;

/**
 * 21 novembre 2018
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<Instruction> programme ;

    public BlocDInstructions(int n) {
        super(n) ;
        programme = new ArrayList<>() ;
    }
    
    public void ajouter(Instruction i) {
        programme.add(i) ;
    }

    @Override
    public void verifier() {
        //throw new UnsupportedOperationException("fonction verifier non définie ") ;
    }
    
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
