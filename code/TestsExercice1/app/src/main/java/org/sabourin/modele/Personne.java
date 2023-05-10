package org.sabourin.modele;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personne {
    @PrimaryKey
    public Long idPersonne;

    public String nomPersonne;

    public int agePersonne;

    public String adressePersonne;
}
