package sabourin;

import exceptions.MonException;

import java.io.*;
import java.text.ParseException;

//catch an exception only if you can handle it in a meaningful way
//declare throwing the exception upward if it is to be handled by the consumer of the current method
//throw exceptions if they are caused by the input parameters (but these are more often unchecked)

public class Computor {
    public Computor() throws ParseException, MonException {
        //divide(5,0);
        //show(5);
        //showTryCatch(5);
        //plusieursTryCatch();
        //plusieursTryCatchJava7(null);

        //writeFile();

        //throwLots(-5, "yo");
        //throwLots(6000,"3000");

        throwMonException();
    }

    //unchecked --> runtime
    public int divide(int number, int divisor) {
        return number / divisor;
    }

    //unchecked --> runtime
    public void show(int pos) {
        int[] num = {1, 2, 3, 4};
        System.out.println(num[pos]);
    }

    public void showTryCatch(int pos) {
        int[] num = {1, 2, 3, 4};
        try {
            System.out.println(num[pos]);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Catch " + a);
        }
    }

    //checked --> exception (pas runtime exception)
    public void writeFile() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }

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

    public void plusieursTryCatchJava7(String test2) {
        try {
            int[] tab = new int[]{0};
            int[] tab2;
            int test1 = tab[1];

            test2.startsWith("allo");


        } catch (NullPointerException | ArrayIndexOutOfBoundsException | ArithmeticException ex) {
            ex.printStackTrace();
        }
    }

    public void throwLots(int number, String texte) throws ParseException, MonException {
        if (number < 0) throw new MonException("CHIFFRE NÉGATIF");
        if (texte.equals("3000")) throw new ParseException("bla", 0);

        // Pas besoin d'ajouter IllegalArgumentException à la signature  https://stackoverflow.com/questions/5304098/should-i-put-throws-illegalargumentexception-at-the-function
    }

    public void throwMonException() throws MonException {
        try {
            throw new MonException("Pas cool");
        }catch (MonException e){
            System.out.println(e.getMessage());
        }
    }
}
