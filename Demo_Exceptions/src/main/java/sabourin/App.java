package sabourin;

import sabourin.compute.Computor;
import sabourin.exceptions.MonThrowable;

import java.text.ParseException;

public class App 
{
    public static void main( String[] args ) {
        try {
            Computor c = new Computor();
        }catch (ParseException | MonThrowable f){
            System.out.println("remonté jusque dans le main");
        }finally{
            System.out.println("Finally du main, toujours exécuté");
        }
    }
}
