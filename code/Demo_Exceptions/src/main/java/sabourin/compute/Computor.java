package sabourin.compute;

import sabourin.exceptions.MonException;
import java.io.*;
import java.text.ParseException;


public class Computor {
    // TODO 3 On peut aussi créer nos propres   ⬇ ⬇ ⬇ ⬇ ⬇  classes d'exception
    public Computor() throws ParseException, MonException {
        // TODO 4 Décommenter une seule ligne à la fois et exécuter chaque fois
//        divide(5,0);
//        arrayAccess(5);
//        arrayAccessCaught(5);
//        plusieursTryCatch();
//        writeFile();
//        validate(-5, "yo");
//        validate(6000,"3000");
    }

    //region UNCHECKED EXCEPTIONS

    //unchecked --> runtime
    public int divide(int number, int divisor) {
        return number / divisor;
    }

    //unchecked --> runtime
    public void arrayAccess(int pos) {
        int[] num = {1, 2, 3, 4};
        System.out.println(num[pos]);
    }

    public void arrayAccessCaught(int pos) {
        int[] num = {1, 2, 3, 4};
        try {
            System.out.println(num[pos]);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Catch " + a);
        }
    }

    //endregion
    //region CHECKED EXCEPTIONS
    //checked --> pre-runtime
    public void writeFile() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }

    //endregion
    //region IMBRICATED TRY CATCH
    public void plusieursTryCatch() {
        //main try-block
        try {
            //try-block2
            try {
                //try-block3
                try {
                    int[] arr = {1, 2, 3, 4};
                    System.out.println(arr[5]);
                } catch (ArithmeticException e) {
                    System.out.print("Arithmetic Exception");
                    System.out.println("try-block3");
                }
            } catch (ArithmeticException e) {
                System.out.print("Arithmetic Exception");
                System.out.println("try-block2");
            }
        } catch (ArithmeticException e3) {
            System.out.print("Arithmetic Exception");
            System.out.println("main try-block");
        } catch (ArrayIndexOutOfBoundsException e4) {
            System.out.print("ArrayIndexOutOfBoundsException  - ");
            System.out.println("main try-block");
        } catch (Exception e5) {
            System.out.print("Exception");
            System.out.println("main try-block");
        }
    }

    //endregion
    //region THROW
    public void validate(int number, String texte) throws ParseException, MonException {
        if (number < 0) throw new MonException("CHIFFRE NÉGATIF");
        if (texte.equals("3000")) throw new ParseException("bla", 0);
    }
    //endregion
}
