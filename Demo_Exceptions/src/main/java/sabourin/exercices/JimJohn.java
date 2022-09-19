package sabourin.exercices;
import java.io.*;

public class JimJohn
{
    public static void main( String[] args ) {
        lireDesFichiersJimmy();
        lireDesFichiersJohnny();

    }

    public static void lireDesFichiersJimmy(){
        for (int i = 0 ; i < 10 ; i++ ){
            try {
                lireFichier(i);
            } catch (FileNotFoundException e) {
                System.out.println("fichier " + i + " n'existe pas Jimmy");
            }
        }
    }

    public static void lireDesFichiersJohnny(){
        int cpt = 0;
        try {
            for (int i = 0 ; i < 10 ; i++ ){
                lireFichier(i);
                cpt = i;
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichier " + cpt + " n'existe pas Johnny");
        }
    }

    public static void lireFichier(int i) throws FileNotFoundException {
        File f = new File("./files/toto" + i + ".txt");
        FileReader fr = new FileReader(f);
        // System.out.println("J'ai 'lu' le fichier " + i);
    }

}
