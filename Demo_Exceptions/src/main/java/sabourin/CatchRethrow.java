package sabourin;

import sabourin.exceptions.MonException;

import java.util.Random;

public class CatchRethrow {

    // Parfois on veut attraper des sabourin.exceptions pour les relancer ensuite ou alors relancer la notre
    public static void main( String[] args ) {
        for (int i = 0 ; i < 10; i++) {
            // dans le main, il faut toujours catch parce qu'on est la derniere methode de la pile
            // si c'est pas nous c'est personne = application crash
            try {
                caPourraitDiviserParZero();
                System.out.println("ca a marche");
            } catch (MonException e) {
                System.out.println("ca a casse");
            }
        }
    }

    // exemple de catch and throw
    // on veut attraper l'exception du systeme (division par zero)
    // pour cacher ce qui se passe et exposer notre exception au developpeur
    public static double caPourraitDiviserParZero() throws MonException {
        try {
            return 10 / new Random().nextInt(2);
        } catch(ArithmeticException e) {
            throw new MonException();
        }
    }

}
