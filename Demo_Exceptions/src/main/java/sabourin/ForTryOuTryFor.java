package sabourin;

import java.io.IOException;
import java.util.Random;

public class ForTryOuTryFor {

    public static void main( String[] args ) {
        System.out.println("For puis Try");
        for (int i = 0 ; i < 10 ; i++ ){
            try {
                System.out.println("iteration  " + i);
                methodeQuiLanceUneExceptionDesFois();
            } catch (IOException e) {
                System.out.println("le catch est dans la boucle, la situation est gérée, on fait la prochaine iteration");
            }
        }

        System.out.println("\n\n\n");
        System.out.println("Try puis For");
        try {
            for (int i = 0 ; i < 10 ; i++ ){
                System.out.println("iteration  " + i);
                methodeQuiLanceUneExceptionDesFois();
            }
        } catch (IOException e) {
            System.out.println("l'exception tue la boucle, ");
        }

    }

    public static void methodeQuiLanceUneExceptionDesFois() throws IOException {
        if (new Random().nextInt(100) < 50) {
            throw new IOException();
        }
    }
}
