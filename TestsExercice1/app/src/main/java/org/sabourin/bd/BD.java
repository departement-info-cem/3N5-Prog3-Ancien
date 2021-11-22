package org.sabourin.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.sabourin.modele.Personne;

@Database(entities = {Personne.class}, version = 1)
public abstract class BD extends RoomDatabase {
    public abstract MonDao monDao();
}
