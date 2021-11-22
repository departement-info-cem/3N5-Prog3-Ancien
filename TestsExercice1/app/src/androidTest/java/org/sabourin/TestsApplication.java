package org.sabourin;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sabourin.bd.BD;
import org.sabourin.modele.Personne;

import org.sabourin.service.ServiceImplementation;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class TestsApplication {

    private BD bd;
    private ServiceImplementation service;

    // S'exécute avant chacun des tests. Crée une BD en mémoire
    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();
        service = ServiceImplementation.getInstance(bd);
    }


    @Test
    public void ajoutPersonneOKBD(){
        Personne personne = new Personne();
        personne.idPersonne = 1L;
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        bd.monDao().insertPersonne(personne);
    }


    @Test
    public void ajoutPersonneKOService() {
        Personne personne = new Personne();
        personne.idPersonne = 2L;
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        service.ajouterPersonne(personne);
    }


}