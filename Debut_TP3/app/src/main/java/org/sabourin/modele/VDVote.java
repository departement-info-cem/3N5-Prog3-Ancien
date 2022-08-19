package org.sabourin.modele;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = VDQuestion.class, parentColumns = "idQuestion", childColumns = "idQuestion", onDelete = CASCADE))
public class VDVote {
    @PrimaryKey(autoGenerate = true)
    public Long idVote;

    public Long idQuestion;

    public int valeurVote;

}
