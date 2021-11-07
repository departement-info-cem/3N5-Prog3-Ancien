package org.sabourin.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.sabourin.modele.VDQuestion;
import org.sabourin.modele.VDVote;

@Database(entities = {VDQuestion.class}, version = 2)
public abstract class BD extends RoomDatabase {
    public abstract MonDao monDao();
}
