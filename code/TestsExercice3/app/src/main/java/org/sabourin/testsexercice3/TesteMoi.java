package org.sabourin.testsexercice3;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class TesteMoi {

    // TODO 1 : Cette fonction brise un principe clé des tests unitaires. Quel est-il?
    // TODO 2 : Modifier le code pour que cette méthode soit facilement testable
    // TODO 3 : Écrire 3 tests et valider si le code est bon
    public void comparerDix(int number){
        if (number > 10){
            System.out.println("notre " + number + "est plus petit que 10");
        } else if (number == 10){
            System.out.println("notre " + number + "est égal à 10");
        } else {
            System.out.println("notre " + number + "est plus grand que 10");
        }
    }


    // TODO 4 : Écrire les tests et valider si le code est bon
    //          Décrire le ou les problèmes
    // Indice : Essayez toutes les combinaisons, et également les choix non gérés
    public String rochePapierGnocchi(String choixA, String choixB){
        if (choixA == choixB){
            return "Égalité";
        }

        if (choixA == "Roche" && choixB == "papier"){
            return "Joueur 2 gagne";
        } else if (choixA == "papier" && choixB == "gnochi"){
            return "Joueur 2 gagne";
        } else if (choixA == "gnocchi" && choixB == "roche "){
            return "Joueur 2 gagne";
        } else {
            return "Joueur 1 gagne";
        }

    }

    // TODO 5 : Voici du code compliqué. Votre travail est uniquement d'écrire les tests.
    //          Règles données par le client :
    //          1 - Une chaîne vide retourne 0
    //          2 - Une chaîne formée uniquement d'espaces retourne 0
    //          3 - Si la chaîne contient un seul chiffre, retourne le chiffre (ex: "2" -> 2)
    //          4 - Si la chaîne contient plus d'un chiffre, les additionne (ex : "12" -> 3)
    //
    //      Bonus : Qu'est-ce qui arrive si on envoie une chaîne ne contenant pas de chiffres?
    //              Et un nombre négatif?
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int calculate(String text) {
        List<String> negatives = new ArrayList<String>();

        if (text == null || text.isEmpty()) {
            return 0;
        }
        char customDelimiter = getCustomDelimiter(text.split("\n")[0]);

        String[] chuncks = (customDelimiter == ',') ?
                text.split(",|\n") : text.split("\n|" + customDelimiter);
        int total = 0;
        int skipFirstLines = (customDelimiter == ',') ? 0 : 2;
        for (String item : chuncks) {
            if (skipFirstLines > 0) {
                --skipFirstLines;
            } else {
                int num = Integer.parseInt(item);
                if (num < 0) {
                    negatives.add(item);
                }
                total += num;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed " + String.join(",", negatives));
        }
        return total;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private char getCustomDelimiter(String line) {
        if (line == null || line.isEmpty()) {
            return ',';
        }
        if (isNumeric(line)) {
            return ',';
        }
        if (line.length() == 1) {
            return line.charAt(0);
        }
        return ',';
    }
}
