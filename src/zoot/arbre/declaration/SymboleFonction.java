package zoot.arbre.declaration;

public class SymboleFonction extends Symbole {
    private String etiquetteFonction;

    /**
     *
     * @param symbole le type de la fonction
     */
    public SymboleFonction(Expression.Type symbole) {
        super(symbole);
    }

    public void setEtiquetteFonction(String etiquetteFonction) {
        this.etiquetteFonction = etiquetteFonction;
    }

    public String getEtiquetteFonction() {
        return etiquetteFonction;
    }
}
