package sabourin;

import exceptions.MonException;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class App 
{
    public static void main( String[] args ) {
        try {
            Computor c = new Computor();
        }catch (ParseException | MonException f){
            System.out.println("remonté jusque dans le main");
        }finally{
            System.out.println("Finally du main");
        }


    }
}
