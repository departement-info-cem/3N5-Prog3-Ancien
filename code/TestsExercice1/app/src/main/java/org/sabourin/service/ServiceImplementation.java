package org.sabourin.service;

import org.sabourin.bd.BD;
import org.sabourin.modele.Personne;

public class ServiceImplementation{

    private static ServiceImplementation single_instance = null;
    private BD maBD;

    private ServiceImplementation (BD maBD){
        this.maBD = maBD;
    }

    public static ServiceImplementation getInstance(BD maBD)
    {
        if (single_instance == null)
            single_instance = new ServiceImplementation(maBD);

        return single_instance;
    }


    public void ajouterPersonne(Personne personne) {
        // Ajout
        personne.idPersonne = maBD.monDao().insertPersonne(personne);
    }
}
