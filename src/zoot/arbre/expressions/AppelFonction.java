package zoot.arbre.expressions;

import zoot.arbre.declaration.EntreeFonction;
import zoot.arbre.declaration.Symbole;
import zoot.arbre.declaration.TDS;

import java.util.ArrayList;

public class AppelFonction extends Expression{
    private String identifiant;

    private final Symbole symbole;

    public AppelFonction(String identifiant, int n){
        super(n);
        this.identifiant = identifiant;
        this.symbole = TDS.getInstance().identifier(new EntreeFonction(identifiant).getIdentifiant());
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return "\t#appelfonction";
    }

    @Override
    public boolean estConstanteEntiere() {
        return false;
    }

    @Override
    public boolean estConstanteBooleenne() {
        return false;
    }

    @Override
    public boolean estIdentifiant() {
        return false;
    }
}
