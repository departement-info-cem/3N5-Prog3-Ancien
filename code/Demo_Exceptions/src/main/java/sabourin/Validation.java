package sabourin;

public class Validation {

    public static void main( String[] args ) {
        try {
            // TODO 1 Décommenter une seule ligne à la fois dans le try et exécuter chaque fois
            validerNomUtilisateur("dieu");
            //validerNomUtilisateur("                     ");
            //validerNomUtilisateur("    cour");
            //validerNomUtilisateur("ceci a l'air d'un nom correct");
        } catch (NomReserve e) {
            System.out.println("Dans ce catch, on peut indiquer pourquoi on refuse la valeur entrée");
        } catch (NomTropCourt e) {
            System.out.println("Et en distinguant les cas, aider l'utilisateur à utiliser notre application");
        } catch (NomTropLong e) {
            System.out.println("Pour chaque cas à distinguer, on peut créer une classe. Ça rend le code lisible");
        }
    }

    public static void validerNomUtilisateur(String nom) throws NomReserve, NomTropCourt, NomTropLong {
        if (nom.equals("dieu")) {
            throw new NomReserve();
        } else if (nom.trim().length() < 5) {
            throw new NomTropCourt();
        } else if (nom.trim().length() > 255) {
            throw new NomTropLong();
        }
    }

    // TODO 2 On peut définir des classes statiques dans une classe
    public static class NomReserve extends Exception{}
    public static class NomTropCourt extends Exception{}
    public static class NomTropLong extends Exception{}
}
