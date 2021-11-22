package org.sabourin.bd;

import androidx.room.Dao;
import androidx.room.Insert;
import org.sabourin.modele.Personne;

@Dao
public interface MonDao {
    @Insert
    Long insertPersonne(Personne p);
}
