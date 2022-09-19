package sabourin;
import sabourin.exceptions.MonException;
import java.util.Random;

public class CatchRethrow {

    //TODO 6 Parfois on veut attraper des exceptions pour les relancer ensuite ou alors relancer la nôtre
    public static void main( String[] args ) {
        for (int i = 0 ; i < 10; i++) {
            try {
                caPourraitDiviserParZero();
                System.out.println("ça a marché");
            } catch (MonException e) {
                System.out.println("ça a cassé " + e);
            }
        }
    }

    // TODO 7 Catch & (Re)Throw
    //  On veut attraper l'exception du système (division par zéro)
    //  Pour cacher ce qui se passe et exposer NOTRE exception au développeur
    public static double caPourraitDiviserParZero() throws MonException {
        try {
            return 10 / new Random().nextInt(2);
        } catch(ArithmeticException e) {
            throw new MonException("Je gère mon exception À MA MANIÈRE OKAY!");
        }
    }

}
