package sabourin;
import sabourin.compute.Computor;
import sabourin.exceptions.MonException;
import java.text.ParseException;

public class App 
{
    //TODO 5 Dans le main, il faut toujours catch parce qu'on est la dernière méthode de la pile
    // si ce n'est pas nous qui attrape, c'est personne ==> l'application crash
    public static void main( String[] args ) {
        try {
            new Computor();
        }catch (ParseException | MonException f){
            System.out.println("L'exception est remontée jusque dans le main");
        }finally{
            System.out.println("Finally du main, c'est toujours exécuté");
        }
    }
}
