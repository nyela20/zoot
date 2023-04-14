package zoot;

import zoot.arbre.declaration.*;

public class Test {
    public static void main(String[] args) {
        Expression e = new Soustraction(
                new Produit(
                        new Addition(
                                new Identifiant("a", 1),
                                new Identifiant("b", 1),
                                1
                        ),
                        new Soustraction(
                                new Addition(
                                        new Identifiant("e", 1),
                                        new ConstanteEntiere("1",1),
                                        1
                                ),
                                new Identifiant("a", 1),
                                1
                        ),
                        1
                ),
                new Addition(
                        new ConstanteEntiere("2",1),
                        new Identifiant("u", 1),
                        1
                ),
                1
        );
        System.out.println(e.getNombrePlaces());
    }
}
