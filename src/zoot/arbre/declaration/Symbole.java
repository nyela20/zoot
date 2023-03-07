package zoot.arbre.declaration;

public abstract class Symbole {
    private final Expression.Type symbole;

    public Symbole(Expression.Type symbole) {
        this.symbole = symbole;
    }

    public Expression.Type getType() {
        return symbole;
    }
}

